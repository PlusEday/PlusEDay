package org.eday.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages = {"org.eday.controller"})
public class ServletConfig implements WebMvcConfigurer {
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean);
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");
	}
	/*	Swagger 사용 시에는 Docket Bean 을 품고있는 설정 클래스 1개가 기본으로 필요하다.
	Spring Boot 에서는 이 기본적인 설정파일 1개로 Swagger 와 Swagger UI 를 함께 사용가능하지만,
	Spring MVC 의 경우 Swagger UI 를 위한 별도의 설정이 필요하다.
	이는, Swagger UI 를 ResourceHandler 에 수동으로 등록해야 하는 작업인데,
	Spring Boot 에서는 이를 자동으로 설정해주지만 Spring MVC 에서는 그렇지 않기 때문이다. */
	
	/* Swagger2를 사용하려면 Docket객체를 Bean으로 설정해야 한다. 
	 * Docket객체에는 어떤 경로의 Web API들을 자동으로 문서화 할 것인지에 
	 * 대한 설정과 문서 설명에 대한 내용이 포함된다. */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.eday.controller")) // 현재 RequestMapping으로 할당된 모든 URL 리스트를 추출
				.paths(PathSelectors.ant("/api/**")) // PathSelectors.any() 를 할경우 모든 경로가 다 사용된다. RestController가 아닌 것까지 사용된다.
				.build()
				.useDefaultResponseMessages(false);
	}
	
}
