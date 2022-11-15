package org.javacream.training.camel.basic.util;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class SimpleReadingProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println(exchange.getProperty("demoProp"));
		Message m = exchange.getIn();
		System.out.println(m.getHeader("demoHeader"));
	}

}
