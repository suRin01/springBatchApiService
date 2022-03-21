package com.surin.apibatchgetter.tasklets;

import com.surin.apibatchgetter.utilities.DataShareBean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class LambertConicSpotDataShareBean implements Tasklet {

    private final DataShareBean<List<List<String>>> lambertConicSpotDataShareBean;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext ) throws Exception{
        List<List<String>> xys = readCSVFile("src/lambert_conic_spots.csv");
        xys.remove(0);
        log.info("Init Data Share Bean");

        lambertConicSpotDataShareBean.putData("spots", xys);

        return RepeatStatus.FINISHED;

    }

    private List<List<String>> readCSVFile(String filePath) {

        List<List<String>> list;
        list = new ArrayList<List<String>>();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = Files.newBufferedReader(Paths.get(filePath));
            String line = "";

            while ((line = bufferedReader.readLine()) != null) {

                List<String> stringList = new ArrayList<>();
                String stringArray[] = line.split(",");

                stringList = Arrays.asList(stringArray);
                list.add(stringList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

}
