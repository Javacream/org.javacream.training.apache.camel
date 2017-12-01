package org.javacream.training.apache.camel.simplerouting;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleRoutingSpringStarter {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("simpleroute-camel-context.xml");
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