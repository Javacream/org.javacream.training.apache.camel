package org.javacream.training.camel.basic;

import org.apache.camel.builder.RouteBuilder;
import org.javacream.training.camel.basic.processor.StringConverterProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class BasicRoute extends RouteBuilder {


	private String from;
	private String to;
	public BasicRoute(String from, String to) {
		this.from = from;
		this.to = to;
	}
	
	@Autowired
	private StringConverterProcessor simpleConverterProcessor;

	@Override
	public void configure() throws Exception {
		from(from).process(simpleConverterProcessor).to(to);
	}

}
