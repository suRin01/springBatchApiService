package com.surin.apibatchgetter.jobs;


import com.surin.apibatchgetter.tasklets.InitDataShareBean;
import com.surin.apibatchgetter.tasklets.SpotDataCrawler;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpotUpdateJob {
    //Factory
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    //Tasklets
    private final InitDataShareBean initDataShareBean;
    private final SpotDataCrawler spotDataCrawler;

    @Bean
    public Job spotGetterJob(){
        return jobBuilderFactory.get("spotGetterJob")
                .start(initDataShareBeanStep())
                .next(completeJobStep())
                .build();
    }

    @Bean
    public Step initDataShareBeanStep() {
        return stepBuilderFactory.get("initDataShareBean")
                .tasklet(initDataShareBean)
                .build();
    }

    @Bean
    public Step completeJobStep(){
        return stepBuilderFactory.get("completeJobStep")
                .tasklet(spotDataCrawler)
                .build();
    }
}
