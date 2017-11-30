package org.javacream.training.apache.camel.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoRouteSpringStarter {

	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("camel-context.xml");
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