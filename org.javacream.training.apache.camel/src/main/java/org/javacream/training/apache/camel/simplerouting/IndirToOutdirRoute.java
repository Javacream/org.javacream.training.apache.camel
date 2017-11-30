package org.javacream.training.apache.camel.simplerouting;

import org.apache.camel.builder.RouteBuilder;
import org.javacream.training.apache.camel.util.NewFilenameProcessor;

public class IndirToOutdirRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file://data/indir?move=backup").process(new NewFilenameProcessor()).to("file://data/outdir");
	}

}
