package org.javacream.training.apache.camel.util;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class DebugProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		printOut("Exchange", exchange);
		Message message = exchange.getIn();
		printOut("In-Message", message);
		printOut("Headers", message.getHeaders());
		printOut("Body", message.getBody());
	}

	private void printOut(String name, Object o) {
		System.out.println("* DebugProcessor, " + name + ":" + o);
	}
}
