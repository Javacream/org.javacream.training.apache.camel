package org.javacream.training.apache.camel.util;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;

public class CamelContextUtil {

	private SimpleRegistry registry;
	private DefaultCamelContext camelContext;

	public void init() {
		registry = new SimpleRegistry();
		camelContext = new DefaultCamelContext(registry);
	}
	public void start() {
		try {
			camelContext.start();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void startBlocking() {
		try {
			camelContext.start();
			Object block = new Object();
			synchronized (block) {
				try {
					block.wait();
				} catch (Exception e) {
					// OK
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void addRoutes(RouteBuilder... routes) {
		for (RouteBuilder route : routes) {
			try {
				camelContext.addRoutes(route);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

	}

	public void addBeans(Object... objects) {
		for (Object o : objects) {

			registry.put(o.getClass().getSimpleName(), o);
		}
	}
}
