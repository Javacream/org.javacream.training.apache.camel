package org.javacream.training.apache.camel.demo;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.javacream.training.echo.EchoBusiness;

public class DemoRouteStarterWithCamelContext {

	public static void main(String[] args) throws Exception {
		SimpleRegistry registry = new SimpleRegistry();
		buildContext(registry);
		CamelContext camelContext = new DefaultCamelContext(registry);
		camelContext.addRoutes(new DemoRoute());
		camelContext.start();
		
		Object block = new Object();
		synchronized (block) {
			try {
				block.wait();
			} catch (Exception e) {
				// OK
			}
		}

		
	}
	
	private static void buildContext(SimpleRegistry registry) {
		registry.put("echoBean", new EchoBusiness());
	}

}
