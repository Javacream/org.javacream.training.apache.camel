package org.javacream.training.camel.basic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.camel.builder.RouteBuilder;
import org.javacream.training.camel.basic.util.SimpleChangingProcessor;
import org.javacream.training.camel.basic.util.SimpleReadingProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BasicNoRoute{

	{
		System.out.println("# constructor: " + this +", " + this.from);
	}
	
	@PostConstruct
	public void initBasicRoute() {
		System.out.println("# postconstruct: " + this +", " + this.from);
	}

	@PreDestroy
	public void cleanup() {
		System.out.println("# predestroy: " + this);
	}

	@Value("${route.from}")
	private String from;
	@Value("${route.to}")
	private String to;
//	@Override
//	public void configure() throws Exception {
//		from(from).process(new SimpleChangingProcessor()).process(new SimpleReadingProcessor()).to(to);
//	}

}
