package org.javacream.training.apache.camel.datatypes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataTypesRouteStarter {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("datatypes-route.xml");
		synchronized (context) {
			context.wait();
		}
		context.close();
	}

}
