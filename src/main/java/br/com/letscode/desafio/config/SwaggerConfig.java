package br.com.letscode.desafio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage(("br.com.letscode.desafio")))
                .build()
                .apiInfo(getApiInfo())
                .useDefaultResponseMessages(false)
                .consumes(Collections.singleton(MediaType.APPLICATION_JSON_VALUE))
                .produces(Collections.singleton(MediaType.APPLICATION_JSON_VALUE));
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Desafio Técnico Lets Code")
                .description("Desafio Técnico Lets Code")
                .version("1.0.0")
                .build();
    }

}
