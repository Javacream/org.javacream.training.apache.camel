package org.javacream.training.apache.camel.choice;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.javacream.training.apache.camel.util.CamelContextUtil;

public class ChoiceRouteRefactored {
	private static final String BASE_DIR = "data/choices_and_subroutes";

	private static final String INDIR = BASE_DIR + "/indir";
	private static final String OUTDIR = BASE_DIR + "/outdir";
	private static final String OUTDIR_XML = OUTDIR + "/xml";
	private static final String OUTDIR_TXT = OUTDIR + "/txt";
	private static final String OUTDIR_TXT_CONTAINS_HELLO = OUTDIR_TXT + "/contains_hello";
	private static final String OUTDIR_TXT_DOES_NOT_CONTAIN_HELLO = OUTDIR_TXT + "/does_not_contain_hello";
	private static final String OUTDIR_OTHER = OUTDIR + "/other";

	private static class EntryRoute extends RouteBuilder {
		@Override
		public void configure() throws Exception {
			from("file://" + INDIR + "?move=backup").choice()
					.when(header(Exchange.FILE_NAME).endsWith(".xml")).to("file://" + OUTDIR_XML).endChoice()
					.otherwise().to("direct://no_xml").endChoice().end();
		}
	}

	private static class NoXmlRoute extends RouteBuilder {
		@Override
		public void configure() throws Exception {
			from("direct://no_xml").choice().when(header(Exchange.FILE_NAME).endsWith(".txt")).to("direct://txt")
					.endChoice().otherwise().to("file://" + OUTDIR_OTHER).endChoice().end();

		}
	}

	private static class TxtRoute extends RouteBuilder {
		@Override
		public void configure() throws Exception {
			from("direct://txt")
			.choice()
				.when(body().convertToString().contains("Hello"))
					.to("file://" + OUTDIR_TXT_CONTAINS_HELLO)
				.endChoice().
				otherwise()
					.to("file://" + OUTDIR_TXT_DOES_NOT_CONTAIN_HELLO)
				.endChoice()
			.end();
		}
	}

	public static void main(String[] args) {
		CamelContextUtil camelContextUtil = new CamelContextUtil();
		camelContextUtil.init();
		camelContextUtil.addRoutes(new EntryRoute(), new NoXmlRoute(), new TxtRoute());
		camelContextUtil.startBlocking();
	}
}
