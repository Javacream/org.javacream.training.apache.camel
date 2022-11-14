package org.javacream.training.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleRouteBuilder extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from("timer:name_of_the_timer_unused_here").log("Hello World!");
	}
};
