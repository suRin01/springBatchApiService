package com.surin.apibatchgetter.tasklets;

import com.google.gson.JsonSyntaxException;
import com.surin.apibatchgetter.DTO.WeatherResponse.WeatherResponseStructure;
import com.surin.apibatchgetter.entities.LambertConicSpot;
import com.surin.apibatchgetter.entities.Weather;
import com.surin.apibatchgetter.httpClient.WeatherClient;
import com.surin.apibatchgetter.repositories.WeatherRepository;
import com.surin.apibatchgetter.utilities.DataShareBean;
import com.surin.apibatchgetter.utilities.PropertyUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;
import retrofit2.Call;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class WeatherDataCrawler implements Tasklet {

    //Data Share Bean
    private final DataShareBean<List<List<String>>> lambertConicSpotDataShareBean;

    private  final WeatherRepository weatherRepository;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext ) throws Exception{
        //get working location
        List<List<String>> lambertConicSpots = lambertConicSpotDataShareBean.getData("spots");

        if(lambertConicSpots.size() == 0){
            return RepeatStatus.FINISHED;
        }

        List<String> currentLambertConicSpot = lambertConicSpots.get(0);

        //make request
        log.info("Get Spot List From Api");
        Call<WeatherResponseStructure<Weather>> weatherRequest
                = WeatherClient.getApiService().getWeatherOnXY(PropertyUtil.getProperty("WeatherApi.SecretKey"),
                10000,
                1,
                "JSON",
                (new SimpleDateFormat("yyyyMMdd")).format(new Date()),
//                "20220321",
                "0500",
                Integer.parseInt(currentLambertConicSpot.get(0)),
                Integer.parseInt(currentLambertConicSpot.get(1)));
        try {
            //call api via nx, ny
            log.info("Execute Weather Api Request");
            WeatherResponseStructure<Weather> response = weatherRequest.execute().body();
            log.info("Got Data From Area Code: {}, {}", currentLambertConicSpot.get(0), currentLambertConicSpot.get(1));
            List<Weather> weatherList = response.getItems();
            log.info("Got Data Count : {}", weatherList.size());
            log.info("Save Crawled Data to Database");
            weatherRepository.saveAll(weatherList);
            log.info("Update Spot Cursor");
            // remove updated location
            lambertConicSpots.remove(0);
            lambertConicSpotDataShareBean.updateData("spots", lambertConicSpots);
            log.info("Left task count : {}", lambertConicSpots.size());
            return RepeatStatus.CONTINUABLE;
        }catch (IOException e){
            log.info("Error occurred during executing request. do this step again in 30 minutes");
            Thread.sleep(1000 * 60 * 30);
            return RepeatStatus.CONTINUABLE;
        }catch (JsonSyntaxException jsonSyntaxException){
            log.error("Error occurred during executing request. daily limit expired");
            return RepeatStatus.FINISHED;
        }
    }
}
