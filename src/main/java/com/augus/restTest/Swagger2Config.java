package com.augus.restTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.augus.restTest.controller"))
                .paths(PathSelectors.regex("(/\\w+)\\b(?<!\\bhome)|(/\\w+/.+)"))
                .build().apiInfo(apiEndPointsInfo())
                .tags(new Tag("clientes", "Operações para manipular clientes"),
                        new Tag("produtos", "Operações para manipular produtos"),
                        new Tag("pedidos", "Operações para manipular pedidos"));
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Spring Boot REST API")
                .description("API Java Spring com base de dados SQLite")
                .contact(new Contact("Augusto César Bisognin", "http://github.com/augustocb23", "augustocb@gmail.com"))
                .license("MIT License").licenseUrl("https://mit-license.org")
                .version("1.0.0")
                .build();
    }
}