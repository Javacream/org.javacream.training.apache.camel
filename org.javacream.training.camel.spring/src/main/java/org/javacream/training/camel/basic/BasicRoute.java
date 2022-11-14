package org.javacream.training.camel.basic;

import org.apache.camel.builder.RouteBuilder;
import org.javacream.training.camel.basic.util.SimpleChangingProcessor;
import org.javacream.training.camel.basic.util.SimpleReadingProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BasicRoute extends RouteBuilder{

	@Value("${route.from}")
	private String from;
	@Value("${route.to}")
	private String to;
	@Override
	public void configure() throws Exception {
		from(from).process(new SimpleChangingProcessor()).process(new SimpleReadingProcessor()).to(to);
	}

}
