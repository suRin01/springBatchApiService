package com.surin.apibatchgetter;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableBatchProcessing
@SpringBootApplication
public class ApiBatchGetterApplication {

    public static void main( String[] args ) {
        SpringApplication.run(ApiBatchGetterApplication.class, args);
    }

}
