package org.javacream.training.apache.camel.demo;

import org.apache.camel.builder.RouteBuilder;
import org.javacream.training.echo.EchoBusiness;

public class DemoRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("file://data/indir?noop=true").setHeader("ReverseMode", constant(true)).process(new DemoProcessor())
				.bean("echoBean").to("stream:out");
	}

}
