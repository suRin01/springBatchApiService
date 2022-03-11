package com.surin.apibatchgetter.tasklets;

import com.surin.apibatchgetter.DTO.Resopnse.ResponseStructure;
import com.surin.apibatchgetter.entities.Spot;
import com.surin.apibatchgetter.httpClient.SpotClient;
import com.surin.apibatchgetter.utilities.DataShareBean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class SpotCodeExtractor implements Tasklet {

    private final DataShareBean<List<Spot>> dataShareBean;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext ) throws Exception{
        log.info("Get Area Codes");
        Call<ResponseStructure<Spot>> spotRequest = SpotClient.getApiService().getAreaBasedList("isDW+bDvas2+e7a0cIHtQ6R8MueDRle8LRPpKDvkuGB85OzSc0rkuyWW+r7v9ApXBYzD5SjBdzJmELHSjbq0wg==", 10, 2, "WIN", "SpringTour", "1", "json");
        try {
            ResponseStructure<Spot> response = spotRequest.execute().body();
            dataShareBean.putData("spotData", response.getItems());



        }catch (IOException e){
            e.printStackTrace();
        }
        return RepeatStatus.FINISHED;

    }


}
