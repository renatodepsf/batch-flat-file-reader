package com.example.batchflatfileitem.reader;

import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.example.batchflatfileitem.config.S3ClientConfig;
import com.example.batchflatfileitem.model.Relatorio;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.InputStreamResource;
import org.springframework.validation.BindException;

@Configuration
public class MigracaoReaderConfig {

    private final S3ClientConfig s3Configuration;

    public MigracaoReaderConfig(S3ClientConfig s3Configuration) {
        this.s3Configuration = s3Configuration;
    }

    @Bean
    @StepScope
    public FlatFileItemReader<Relatorio> relatorioReader() {
        S3ObjectInputStream conteudoObjeto = s3Configuration.getConteudoObjeto();
        if(conteudoObjeto == null) {
            throw new IllegalArgumentException("Conteúdo do objeto está nulo.");
        }
        return new FlatFileItemReaderBuilder<Relatorio>()
                .name("relatorioItemReader")
                .resource(new InputStreamResource(conteudoObjeto))
                .linesToSkip(1)
                .lineTokenizer(fixaTamanhoConteudo())
                .fieldSetMapper(new RelatorioFieldSetMapper())
                .build();
    }

    // determina o nome dos campos (setName) e o intervalo de caracteres de cada campo (setColumns)
    @Bean
    public FixedLengthTokenizer fixaTamanhoConteudo() {
        FixedLengthTokenizer tokenizer = new FixedLengthTokenizer();
        tokenizer.setNames("dataHora", "numero", "status", "cdStatus", "evento", "tentativas");
        tokenizer.setColumns(new Range(1, 19), new Range(28, 41), new Range(43, 57), new Range(59, 76), new Range(111, 111), new Range(113, 113));
        return tokenizer;
    }

    public static class RelatorioFieldSetMapper implements FieldSetMapper<Relatorio> {

        @Override
        public Relatorio mapFieldSet(FieldSet fieldSet) throws BindException {
            return new Relatorio(
                    fieldSet.readString("dataHora"),
                    fieldSet.readString("numero"),
                    fieldSet.readString("status"),
                    fieldSet.readString("cdStatus"),
                    fieldSet.readString("evento"),
                    fieldSet.readString("tentativas")
            );
        }
    }
}
