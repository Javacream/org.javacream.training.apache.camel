package org.javacream.training.apache.camel.util;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class NewFilenameProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		final String FILENAME_HEADER = "CamelFileName";
		//TODO: Change filename...
		Message message =  exchange.getIn();
		String filename = (String) message.getHeader(FILENAME_HEADER);
		message.setHeader(FILENAME_HEADER, filename.toUpperCase());
	}

}
