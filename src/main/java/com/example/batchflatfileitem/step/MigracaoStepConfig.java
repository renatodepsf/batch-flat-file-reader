package com.example.batchflatfileitem.step;

import com.example.batchflatfileitem.model.Relatorio;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MigracaoStepConfig {

    private final StepBuilderFactory stepBuilderFactory;
    private FlatFileItemReader<Relatorio> reader;
    private ItemProcessor<Relatorio, Relatorio> processor;
    private ItemWriter<Relatorio> writer;

    public MigracaoStepConfig(StepBuilderFactory stepBuilderFactory,
                              FlatFileItemReader<Relatorio> reader,
                              ItemProcessor<Relatorio, Relatorio> processor,
                              ItemWriter<Relatorio> writer) {
        this.stepBuilderFactory = stepBuilderFactory;
        this.reader = reader;
        this.processor = processor;
        this.writer = writer;
    }

    @Bean
    public Step migracaoStep() {
        return stepBuilderFactory.get("migracaoStep")
                .<Relatorio, Relatorio>chunk(1)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
