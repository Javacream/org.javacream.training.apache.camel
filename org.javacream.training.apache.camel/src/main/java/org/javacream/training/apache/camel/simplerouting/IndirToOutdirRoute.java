package org.javacream.training.apache.camel.simplerouting;

import org.apache.camel.builder.RouteBuilder;

public class IndirToOutdirRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file://data/indir?move=backup").to("file://data/outdir");
	}

}
