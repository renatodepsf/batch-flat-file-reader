package com.example.batchflatfileitem.processor;

import com.example.batchflatfileitem.model.Relatorio;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class MigracaoProcessor implements ItemProcessor<Relatorio, Relatorio> {
    @Override
    public Relatorio process(Relatorio relatorio) throws Exception {
        return relatorio;
    }
}
