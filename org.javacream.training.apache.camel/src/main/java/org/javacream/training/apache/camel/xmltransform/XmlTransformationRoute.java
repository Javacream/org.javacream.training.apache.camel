package org.javacream.training.apache.camel.xmltransform;

import org.apache.camel.main.Main;
import org.apache.camel.builder.RouteBuilder;

public class XmlTransformationRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("file://data/xml/indir").to("xslt://file:data/xml/schema/person.xsl").to("file://data/xml/outdir");
	}

	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.addRouteBuilder(new XmlTransformationRoute());
		main.run(args);

	}
}
