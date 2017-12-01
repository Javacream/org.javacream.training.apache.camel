package org.javacream.training.apache.camel.demo;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;


public class DemoRouteStarterWithContext {

	public static void main(String[] args) throws Exception {
		CamelContext camelContext = new DefaultCamelContext();
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

}
