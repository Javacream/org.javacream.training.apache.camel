package org.javacream.training.apache.camel.demo;

import org.apache.camel.builder.RouteBuilder;

public class DemoRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:data/indir?noop=true").to("file:data/outdir");
	}

	

}
