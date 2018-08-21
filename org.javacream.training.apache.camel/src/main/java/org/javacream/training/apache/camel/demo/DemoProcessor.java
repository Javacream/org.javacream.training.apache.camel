package org.javacream.training.apache.camel.demo;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class DemoProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message inMessage = exchange.getIn();
//		inMessage.setHeader("CamelFileName", "HUGO.TXT");
//		inMessage.setBody("HUGO");
		System.out.println("INMESSAGE: " + inMessage);
		System.out.println("*** Exchange: " + exchange);
	}

}
