package com.ashu.practice.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		// @formatter:off
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ashu.practice.controller"))
				.paths(PathSelectors.ant("/employees/**"))
				.build()
				.apiInfo(apiInfo());
		// @formatter:on
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("Ashutosh Sahoo", "www.example.com", "myemail@company.com");
		return new ApiInfo("Employee REST API", "Provides services to manage employees.", "2.0.0",
				"https://www.example.com", contact, "License of API", "https://www.example.com",
				Collections.emptyList());
	}
}
