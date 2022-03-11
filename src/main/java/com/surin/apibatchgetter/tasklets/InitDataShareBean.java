package com.surin.apibatchgetter.tasklets;

import com.surin.apibatchgetter.utilities.DataShareBean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitDataShareBean implements Tasklet {

    private final DataShareBean<int[]> intArrayDataShareBean;
    private final DataShareBean<Integer> integerDataShareBean;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext ) throws Exception{
        log.info("Init Data Share Bean");
        int[] areaCode = {1, 2, 3, 4, 5, 6, 7, 8, 31, 32, 33, 34, 35, 36, 37, 38, 39};
        intArrayDataShareBean.putData("areaCodeList", areaCode);
        integerDataShareBean.putData("areaCodeListCursor", 0);

        return RepeatStatus.FINISHED;

    }
}
