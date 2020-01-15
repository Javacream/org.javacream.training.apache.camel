package org.javacream.training.apache.camel.simplerouting;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.SimpleBuilder;
import org.apache.camel.builder.ValueBuilder;

public class IndirToOutdirRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// from("file://data/indir?move=backup").process(new
		// NewFilenameProcessor()).to("file://data/outdir");
		SimpleBuilder expression = this.simple("Hugo" + Math.random() + ".txt");
		ValueBuilder bodyExpression = body();
		bodyExpression = bodyExpression.regexReplaceAll("i", "I");
		from("file://data/indir?move=backup").setHeader("CamelFileName", expression).transform(bodyExpression)
				.to("file://data/outdir");
	}

}
