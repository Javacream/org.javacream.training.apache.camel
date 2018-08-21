package org.javacream.training.echo;

import org.apache.camel.Body;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.apache.camel.Header;

public class EchoBusiness {

	@Handler
	public String echo(@Body String message, @Header("ReverseMode") Boolean reverseMode, CamelContext camelContext, Exchange exchange) {
		System.out.println("*** " + camelContext);
		System.out.println("*** " + exchange);
		if (reverseMode != null && reverseMode) {
			message = new StringBuilder(message).reverse().toString();
		}
		return "Echoing " + message;
	}

	public String echo2(String message) {
		return "Echoing2 " + message;
	}

}
