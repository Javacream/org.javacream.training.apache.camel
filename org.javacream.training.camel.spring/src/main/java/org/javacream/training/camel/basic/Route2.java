package org.javacream.training.camel.basic;

import org.apache.camel.builder.RouteBuilder;
import org.javacream.training.camel.basic.processor.StringConverterProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Route2 extends RouteBuilder {

	@Value("${route2.from}")
	private String from;
	@Value("${route2.to}")
	private String to;

	@Autowired
	private StringConverterProcessor simpleConverterProcessor;

	@Override
	public void configure() throws Exception {
		from(from).process(simpleConverterProcessor).to(to);
	}

}
