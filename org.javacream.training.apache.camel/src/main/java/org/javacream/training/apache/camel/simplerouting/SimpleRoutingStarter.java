package org.javacream.training.apache.camel.simplerouting;

import org.apache.camel.main.Main;


public class SimpleRoutingStarter {

	public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.addRouteBuilder(new IndirToOutdirRoute());
        main.addRouteBuilder(new OutdirToOutstreamRoute());
        main.run(args);

		
	}

}
