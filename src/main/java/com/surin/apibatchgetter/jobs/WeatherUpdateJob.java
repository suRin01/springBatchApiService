package com.surin.apibatchgetter.jobs;

import com.surin.apibatchgetter.tasklets.LambertConicSpotDataShareBean;
import com.surin.apibatchgetter.tasklets.WeatherDataCrawler;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class WeatherUpdateJob {
    //Factory
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    //Tasklets
    private final LambertConicSpotDataShareBean lambertConicSpotDataShareBean;
    private final WeatherDataCrawler weatherDataCrawler;

    @Bean
    public Job WeatherUpdateJob(){
        return jobBuilderFactory.get("WeatherGetterJob")
                .start(initSpotDataShareBeanStep())
                .next(completeWeatherJobStep())
                .build();
    }

    @Bean
    public Step initSpotDataShareBeanStep() {
        return stepBuilderFactory.get("initDataShareBean")
                .tasklet(lambertConicSpotDataShareBean)
                .build();
    }

    @Bean
    public Step completeWeatherJobStep(){
        return stepBuilderFactory.get("completeWeatherJobStep")
                .tasklet(weatherDataCrawler)
                .build();
    }
}
