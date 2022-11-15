package org.javacream.training.camel.basic;

import org.apache.camel.builder.RouteBuilder;
import org.javacream.training.camel.basic.processor.StringConverterProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfiguration {

	@Bean
	public RouteBuilder route1(@Value("${route1.from}") String from, @Value("${route1.to}") String to
			) {
		return new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from(from).setHeader("to", constant(to)).to("direct:processing");
			}
		};
	}

	@Bean public RouteBuilder direct(StringConverterProcessor processor) {
		return new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from("direct:processing").process(processor).toD("${header.to}");
			}
		};
		
	}
	@Bean
	public RouteBuilder route2(@Value("${route2.from}") String from, @Value("${route2.to}") String to) {
		return new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from(from).setHeader("to", constant(to)).to("direct:processing");
			}
		};
	}
	@Bean
	public RouteBuilder route3() {
		return new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from("file:data2/in?noop=true").to("file:data2/out?fileName=copy-of-${file:name}");
			}
		};
	}

}
