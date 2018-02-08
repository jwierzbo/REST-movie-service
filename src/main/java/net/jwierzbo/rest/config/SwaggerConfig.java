package net.jwierzbo.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .globalResponseMessage(RequestMethod.GET,
                        Arrays.asList(new ResponseMessageBuilder()
                                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                                .build()))
                .select()
                    .apis(RequestHandlerSelectors.basePackage("net.jwierzbo.rest"))
                    .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Favourites movies API")
                .description("CRUD example REST API to manage list of movies")
                .contact(new Contact("jwierzbo", "url", "jwierzbo@jwierzbo.net"))
                .license("MIT")
                .version("0.1")
                .build();
    }
}