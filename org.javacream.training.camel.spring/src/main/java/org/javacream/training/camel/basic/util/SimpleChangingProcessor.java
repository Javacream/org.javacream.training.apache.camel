package org.javacream.training.camel.basic.util;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SimpleChangingProcessor implements Processor {

	
	@Value("${demoProp}") private int demoProp;
	@Value("${demoHeader}") private int demoHeader;
	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println(exchange);
		exchange.setProperty("demoProp", demoProp);
		Message m = exchange.getIn();
		m.setHeader("demoHeader", demoHeader);
		m.setBody(m.getBody().toString().toUpperCase());
	}

}
