package com.example.batchflatfileitem.writer;

import com.example.batchflatfileitem.model.Relatorio;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MigracaoWriterStep implements ItemWriter<Relatorio> {

    @Override
    public void write(List<? extends Relatorio> list) throws Exception {
        list.forEach(System.out::println);
    }
}
