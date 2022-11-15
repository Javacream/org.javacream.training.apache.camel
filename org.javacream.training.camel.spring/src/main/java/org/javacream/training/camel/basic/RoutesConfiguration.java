package org.javacream.training.camel.basic;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfiguration {
	@Value("${route1.from}")
	private String from1;
	@Value("${route1.to}")
	private String to1;
	
	@Value("${route2.from}")
	private String from2;
	@Value("${route2.to}")
	private String to2;

	@Bean public RouteBuilder route1() {
		return new BasicRoute(from1, to1);
	}
	@Bean public RouteBuilder route2() {
		return new BasicRoute(from2, to2);
	}

}
