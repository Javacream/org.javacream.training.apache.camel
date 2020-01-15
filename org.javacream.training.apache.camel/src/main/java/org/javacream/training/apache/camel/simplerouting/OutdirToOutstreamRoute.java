package org.javacream.training.apache.camel.simplerouting;

import org.apache.camel.builder.RouteBuilder;
import org.javacream.training.apache.camel.util.DebugProcessor;
import org.javacream.training.apache.camel.util.NewBodyProcessor;

public class OutdirToOutstreamRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file://data/outdir?noop=true").process(new DebugProcessor()).process(new NewBodyProcessor()).to("stream:out");
	}

}
