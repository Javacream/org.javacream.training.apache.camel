package org.javacream.training.apache.camel.complexfile;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.apache.camel.Message;

public class TextAlgorithmProcessor {

	@Handler public String extractAlgorithm(String body, Exchange exchange) {
		int firstLine = body.indexOf("\r\n");
		String algorithm = body.substring(0, firstLine);
		Message message = exchange.getIn();
		message.setHeader("TextConverterAlgorithm", algorithm);
		message.setBody(body.substring(firstLine));
		String newBody =  body.substring(firstLine + 2);
		return newBody;
	}
}
