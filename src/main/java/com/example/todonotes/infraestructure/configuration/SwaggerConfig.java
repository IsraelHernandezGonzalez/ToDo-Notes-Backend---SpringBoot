package com.example.todonotes.infraestructure.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String AUTHORIZATION_JWT_REFERENCE = "Auth_JWT";

    @Bean
	public Docket api() {
	
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("public-api")
            .apiInfo(apiInfo())
            .securityContexts(Arrays.asList(securityContext()))
            .securitySchemes(Arrays.asList(apiKey()))
            .select() 
            .apis(RequestHandlerSelectors.any())             
            .paths(regex("/api/ToDo.*"))
            .build();
	}
   
    @Bean
	public Docket apiAuth() {       

        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("authentication")
            .apiInfo(apiInfo())
            .select() 
            .apis(RequestHandlerSelectors.any()) 
            .paths(regex("/api/authentication.*"))
            .build();
	}

    private ApiKey apiKey() {
        return new ApiKey(AUTHORIZATION_JWT_REFERENCE, AUTHORIZATION_HEADER, "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference(AUTHORIZATION_JWT_REFERENCE, authorizationScopes));
    }
	

    private ApiInfo apiInfo() {
        return new ApiInfo("MyApp Rest APIs",
                "APIs for MyApp.",
                "1.0",
                "Terms of service",
                new Contact("ToDo Note Demo", "www.ToDoNoteDemo.com", "ToDoNoteDemo@emaildomain.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }
}
