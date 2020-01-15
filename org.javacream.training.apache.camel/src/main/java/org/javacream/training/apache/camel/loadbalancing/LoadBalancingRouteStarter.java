package org.javacream.training.apache.camel.loadbalancing;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoadBalancingRouteStarter {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("loadbalancing-route.xml");
		synchronized (context) {
			context.wait();
		}
		context.close();
	}

}
