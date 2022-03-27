package com.surin.apibatchgetter.schedulers;

import com.surin.apibatchgetter.jobs.SpotUpdateJob;
import com.surin.apibatchgetter.jobs.WeatherUpdateJob;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DailyScheduler {
    private final SpotUpdateJob spotUpdateJob;
    private final WeatherUpdateJob weatherUpdateJob;
    private final JobLauncher jobLauncher;

//    @Scheduled(fixedDelay = 5 * 1000L)
//    public void executedJob(){
//        try{
//            jobLauncher.run(
//                    spotUpdateJob.spotGetterJob(),
//                    new JobParametersBuilder()
//                            .addString("datetime", LocalDateTime.now().toString())
//                            .toJobParameters()
//            );
//        }catch (JobExecutionException ex){
//            System.out.println(ex.getMessage());
//            ex.printStackTrace();
//        }
//    }

    @Scheduled(cron = "0 0 7 * * *")
    public void executedJob2(){
        try{
            jobLauncher.run(
                    weatherUpdateJob.WeatherUpdateJob(),
                    new JobParametersBuilder()
                            .addString("datetime", LocalDateTime.now().toString())
                            .toJobParameters()
            );
        }catch (JobExecutionException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
