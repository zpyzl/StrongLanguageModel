package com.zpy.yearn.parser;

import com.zpy.yearn.parser.service.StanfordParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianServiceExporter;

@SpringBootApplication
public class StanfordParserApplication {

    public static void main(String[] args) {
        SpringApplication.run(StanfordParserApplication.class, args);

    }
    @Autowired
    private StanfordParserService stanfordParserService;

    @Bean(name = "/StanfordParserService")
    public HessianServiceExporter accountService() {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(stanfordParserService);
        exporter.setServiceInterface(StanfordParserService.class);
        return exporter;
    }


}
