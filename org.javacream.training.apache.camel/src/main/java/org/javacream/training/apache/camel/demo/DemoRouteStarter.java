package org.javacream.training.apache.camel.demo;

import org.apache.camel.main.Main;


public class DemoRouteStarter {

	public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.addRouteBuilder(new DemoRoute());
        main.run(args);

		
	}

}
