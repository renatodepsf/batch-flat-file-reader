package com.example.batchflatfileitem.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class MigracaoJobConfig {

    private final JobBuilderFactory jobBuilderFactory;

    public MigracaoJobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job migracaoJob(Step migracaoStep) {
        return jobBuilderFactory.get("migracaoJob")
                .incrementer(new RunIdIncrementer())
                .start(migracaoStep)
                .build();
    }
}
