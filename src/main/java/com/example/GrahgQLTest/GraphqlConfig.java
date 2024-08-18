package com.example.GrahgQLTest;

import org.slf4j.Logger;
import graphql.scalars.ExtendedScalars;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphqlConfig {

    public static final Logger log = LoggerFactory.getLogger(GraphqlConfig.class);


    @Bean
    RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return writingBuilder -> writingBuilder
                .scalar(ExtendedScalars.Date);
    }

    @Bean
    GraphQlSourceBuilderCustomizer inspectionCustomize() {
        return source -> source.inspectSchemaMappings(report -> {
            log.info("Mapowanie schematów: {}", report);
        });
    }
}
