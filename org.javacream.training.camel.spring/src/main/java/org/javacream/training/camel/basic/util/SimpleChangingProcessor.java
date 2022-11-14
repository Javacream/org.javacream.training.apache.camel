package org.javacream.training.camel.basic.util;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class SimpleChangingProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println(exchange);
		exchange.setProperty("demoProp", 42);
		Message m = exchange.getIn();
		m.setHeader("demoHeader", 4711);
		m.setBody(m.getBody().toString().toUpperCase());
	}

}
