package org.javacream.training.echo;

import org.apache.camel.Body;
import org.apache.camel.Handler;
import org.apache.camel.Header;

public class EchoBusiness {

	@Handler
	public String echo(@Body String message, @Header("ReverseMode") boolean reverseMode) {
		if (reverseMode) {
			message = new StringBuilder(message).reverse().toString();
		}
		return "Echoing " + message;
	}

	public String echo2(String message) {
		return "Echoing2 " + message;
	}

}
