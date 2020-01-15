package org.javacream.training.apache.camel.systemreadertofile;

import java.util.StringTokenizer;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class SystemReaderProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
		String input = in.getBody(String.class);
		StringTokenizer st = new StringTokenizer(input, "=");
		in.setHeader(Exchange.FILE_NAME, st.nextToken());
		in.setBody(st.nextToken());
	}

}
