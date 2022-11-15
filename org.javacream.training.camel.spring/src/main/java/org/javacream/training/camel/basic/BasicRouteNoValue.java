package org.javacream.training.camel.basic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.camel.builder.RouteBuilder;
import org.javacream.training.camel.basic.util.SimpleChangingProcessor;
import org.javacream.training.camel.basic.util.SimpleReadingProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BasicRouteNoValue extends RouteBuilder{

	{
		System.out.println("# constructor: " + this);
	}
	
	@PostConstruct
	public void initBasicRoute() {
		System.out.println("# postconstruct: " + this);
	}

	@PreDestroy
	public void cleanup() {
		System.out.println("# predestroy: " + this);
	}

	@Override
	public void configure() throws Exception {
		from("{{route.from}}").process(new SimpleChangingProcessor()).process(new SimpleReadingProcessor()).to("{{route.to}}");
	}

}
