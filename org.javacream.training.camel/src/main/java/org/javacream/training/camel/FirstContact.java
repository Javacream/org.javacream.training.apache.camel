package org.javacream.training.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FirstContact {
	public static void main(String[] args) {
		System.out.println("Starting main...");
		try {
			DefaultCamelContext context = new DefaultCamelContext();
			RouteBuilder builder = new RouteBuilder() {

				@Override
				public void configure() throws Exception {
					from("timer:name_of_the_timer_unused_here").log("Hello World!");
				}
			};
			context.addRoutes(builder);
			context.start();
			Thread.sleep(5000);
			context.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
