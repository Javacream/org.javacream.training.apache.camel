package org.javacream.training.camel.basic;

import org.apache.camel.builder.RouteBuilder;
import org.javacream.training.camel.basic.processor.StringConverterProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfiguration {

	@Bean
	public RouteBuilder route1(@Value("${route1.from}") String from, @Value("${route1.to}") String to,
			StringConverterProcessor processor) {
		return new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from(from).process(processor).to(to);
			}
		};
	}

	@Bean
	public RouteBuilder route2(@Value("${route2.from}") String from, @Value("${route2.to}") String to,
			StringConverterProcessor processor) {
		return new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from(from).process(processor).to(to);
			}
		};
	}

}
