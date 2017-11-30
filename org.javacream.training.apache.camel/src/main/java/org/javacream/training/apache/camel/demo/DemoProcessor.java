package org.javacream.training.apache.camel.demo;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class DemoProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("*** Exchange: " + exchange);
	}

}
