package com.surin.apibatchgetter.tasklets;

import com.surin.apibatchgetter.DTO.Resopnse.ResponseStructure;
import com.surin.apibatchgetter.entities.Spot;
import com.surin.apibatchgetter.httpClient.SpotClient;
import com.surin.apibatchgetter.repositories.SpotRepository;
import com.surin.apibatchgetter.utilities.DataShareBean;
import com.surin.apibatchgetter.utilities.PropertyUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class SpotDataCrawler implements Tasklet {

    //Data Share Bean
    private final DataShareBean<List<Spot>> dataShareBean;
    private final DataShareBean<int[]> intArrayDataShareBean;
    private final DataShareBean<Integer> integerDataShareBean;

    private final SpotRepository spotRepository;

//    @Value("${SpotApi.SecretKey")
//    private String secretKey;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext ) throws Exception{
        int currentCursor = integerDataShareBean.getData("areaCodeListCursor");
        int targetAreaCode = intArrayDataShareBean.getData("areaCodeList")[currentCursor];
        if(currentCursor < intArrayDataShareBean.getData("areaCodeList").length){
            integerDataShareBean.updateData("areaCodeListCursor", currentCursor += 1);
            log.info("Get Spot List From Api");
            Call<ResponseStructure<Spot>> spotRequest
                    = SpotClient.getApiService().getAreaBasedList(
                    PropertyUtil.getProperty("SpotApi.SecretKey"),
                    10000,
                    1,
                    "WIN",
                    "SpringTour",
                    Integer.toString(targetAreaCode),
                    "json");
            try {
                log.info("Execute Tour Spot Api Request");
                ResponseStructure<Spot> response = spotRequest.execute().body();
                log.info("Got Data From Area Code: {}", targetAreaCode);
                log.info("Got Data Count : {}", response.getItems().size());
                dataShareBean.putData("spotData", response.getItems());

                log.info("Save Crawled Data to Database");
                spotRepository.saveAll(response.getItems());

                log.info("Update Spot Cursor");

                return RepeatStatus.CONTINUABLE;


            }catch (IOException e){
                e.printStackTrace();
            }

        }
        return RepeatStatus.FINISHED;
    }
}
