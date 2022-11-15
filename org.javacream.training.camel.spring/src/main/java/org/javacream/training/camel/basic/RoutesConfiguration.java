package org.javacream.training.camel.basic;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfiguration {

	@Bean
	public RouteBuilder route1(@Value("${route1.from}") String from, @Value("${route1.to}") String to) {
		return new BasicRoute(from, to);
	}

	@Bean
	public RouteBuilder route2(@Value("${route2.from}") String from, @Value("${route2.to}") String to) {
		return new BasicRoute(from, to);
	}

}
