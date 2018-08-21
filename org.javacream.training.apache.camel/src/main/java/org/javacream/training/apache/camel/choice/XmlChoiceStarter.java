package org.javacream.training.apache.camel.choice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlChoiceStarter {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("choice-route.xml");
		Object block = new Object();
		synchronized (block) {
			try {
				block.wait();
			} catch (Exception e) {
				// OK
			}
		}
		ctx.close();
	}

}
