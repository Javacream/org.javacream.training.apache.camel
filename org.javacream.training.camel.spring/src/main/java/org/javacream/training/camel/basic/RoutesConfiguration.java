package org.javacream.training.camel.basic;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.javacream.training.camel.basic.processor.StringConverterProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:routes.xml")
public class RoutesConfiguration {

	@Bean
	public RouteBuilder direct(StringConverterProcessor processor) {
		return new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from("direct:demo").process(processor).toD("${header.to}");
			}
		};

	}

	@Bean
	public RouteBuilder directRest(StringConverterProcessor processor) {
		return new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				restConfiguration().component("servlet").contextPath("camel").apiContextPath("camel-api").bindingMode(RestBindingMode.auto);
				rest().path("/rest").consumes("application.json").produces("application.json").get().to("direct:rest-demo");
				from("direct:rest-demo").process(processor).log("Hello World");
			}
		};

	}

	
}
