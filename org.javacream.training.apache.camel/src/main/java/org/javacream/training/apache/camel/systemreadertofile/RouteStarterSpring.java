package org.javacream.training.apache.camel.systemreadertofile;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RouteStarterSpring {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("systemreader-route.xml");
		synchronized (context) {
			context.wait();
		}
		context.close();
	}

}
