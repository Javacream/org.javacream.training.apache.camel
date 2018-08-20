package org.javacream.training.apache.camel.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoRouteStarterSpring {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("simple-route.xml");
		synchronized (context) {
			context.wait();
		}
		context.close();
	}

}
