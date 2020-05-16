package com.assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/* This config class for documenting the rest apis and urls. This will help testers to get api related information without developers help
 * */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	/**
	 * Api info.
	 *
	 * @return the api info
	 */
	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("EmployeeService").description("EmployeeService").license("").licenseUrl("")
				.termsOfServiceUrl("").version("1.0.0").build();
	}

	/**
	 * Custom implementation.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.assignment.controller")).build().apiInfo(apiInfo());
	}

}
