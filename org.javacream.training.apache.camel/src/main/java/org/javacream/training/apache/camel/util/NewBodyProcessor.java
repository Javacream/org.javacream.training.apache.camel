package org.javacream.training.apache.camel.util;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class NewBodyProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getIn().setBody("HUGO");
	}

}
