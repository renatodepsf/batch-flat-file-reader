package com.example.batchflatfileitem.config;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3ClientConfig {

    @Value("${ultron.migracao.s3}")
    private String s3Bucket;

    @Value("${ultron.migracao.key}")
    private String keyObject;

    @Bean
    public AmazonS3 amazonS3() {
        return AmazonS3ClientBuilder.standard()
                .withRegion("sa-east-1")
                .build();
    }

    public S3ObjectInputStream getConteudoObjeto() {
        return amazonS3()
                .getObject(s3Bucket, keyObject)
                .getObjectContent();
    }
}
