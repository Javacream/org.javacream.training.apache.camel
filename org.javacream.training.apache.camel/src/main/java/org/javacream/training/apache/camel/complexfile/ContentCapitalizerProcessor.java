package org.javacream.training.apache.camel.complexfile;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class ContentCapitalizerProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
		String input = in.getBody(String.class);
		in.setBody(input.toUpperCase());
	}

}
