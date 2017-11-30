package org.javacream.training.apache.camel.simplerouting;

import org.apache.camel.builder.RouteBuilder;

public class OutdirToOutstreamRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file://data/outdir?noop=true&delete=true").to("stream:out");
	}

}
