package edu.csumb.cst438.productdb.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Product API Documentation")
            .description("Product API description: The following links are RESTful endpoints which allow you to interact with a product mongodb.\n" +
            "There are three operations included in the Product API which include adding products to a mongo database,\n" +
            "retrieving product info by entering an id, and getting all products in the database.")
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .termsOfServiceUrl("")
            .version("1.0.0")
            .build();
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("edu.csumb.cst438.productdb"))
            .paths(regex("/products.*"))
            .build()
            .apiInfo(apiInfo());
    }
}