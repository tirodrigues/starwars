package br.com.b2w.bit.starwars.api.v1.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.b2w.bit.starwars.api.v1.controllers.PlanetaController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(PlanetaController.class.getPackage().getName()))
				.paths(PathSelectors.regex("/api/v1/planeta.*")).build();
	}

}
