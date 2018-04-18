package com.hcl.assessment.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Swagger config class to enable swagger documentation.
 * @author kanika.sharma
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	/**
	 * Generates API documentation.
	 * @return
	 */
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.hcl.assessment.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(metaData());
    }
    
    /**
     * Method to customize API information.
     * 
     */
    private ApiInfo metaData() {
        return new ApiInfo(
                "Spring Boot REST API",
                "Spring Boot REST API for: Fibonacci Series, Reverse Words, Triangle Types and Make One Array",
                "1.0",
                "Terms of service",
                new Contact("Kanika Sharma", "", "kanika.sharma@hcl.com"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
    }
}
