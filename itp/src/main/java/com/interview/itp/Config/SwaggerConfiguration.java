package com.interview.itp.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
	
	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.OAS_30)
	            .useDefaultResponseMessages(false)// false로 설정하면, swagger에서 제공해주는 응답코드  200,401,403,404 )에 대한 기본 메시지 제거
	            .select() // ApiSelectorBuilder를 생성
	            .apis(RequestHandlerSelectors.basePackage("com.interview.itp")) // 컨트롤러가 존재하는 패키지를 basepackage로 지정하여, RequestMapping( GetMapping, PostMapping ... )이 선언된 API를 문서화 함
	            .paths(PathSelectors.any()) // apis()로 선택되어진 API중 특정 path 조건에 맞는 API들을 다시 필터링하여 문서화
	            .build()
	            .apiInfo(apiInfo()); // 제목, 설명 등 문서에 대한 정보들을 보여주기 위해 호출 (아래 class 정의)
	}
	
	
	private ApiInfo apiInfo() { // swagger ui로 노출할 정보
		return new ApiInfoBuilder()
		        .title(" Swagger : Interview Platform ")
		        .description("Interview Platform을 위한 API Docs (Swagger 기반)")
		        .version("1.0")
		        .build();
	}
	
}
