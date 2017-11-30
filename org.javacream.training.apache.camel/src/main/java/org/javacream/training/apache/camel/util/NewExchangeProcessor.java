package org.javacream.training.apache.camel.util;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class NewExchangeProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message newMessage = exchange.getOut();
		newMessage.setBody("EGON"); 
	}

}
