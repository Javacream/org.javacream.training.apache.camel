package org.javacream.training.camel.basic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.camel.builder.RouteBuilder;
import org.javacream.training.camel.basic.util.SimpleChangingProcessor;
import org.javacream.training.camel.basic.util.SimpleReadingProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BasicRoute extends RouteBuilder{

	
	{
		System.out.println("# constructor: " + this);
	}
	
	@PostConstruct
	public void initBasicRoute() {
		System.out.println("# postconstruct: " + this +", " + this.from);
	}

	@PreDestroy
	public void cleanup() {
		System.out.println("# predestroy: " + this +", " + this.from);
	}

	@Value("${route.from}")
	private String from;
	@Value("${route.to}")
	private String to;
	
	@Autowired
	private SimpleReadingProcessor simpleReadingProcessor;
	
	@Autowired
	private SimpleChangingProcessor simpleChangingProcessor;
	
	@Override
	public void configure() throws Exception {
		from(from).process(simpleChangingProcessor).process(simpleReadingProcessor).to(to);
	}

}
