package org.javacream.training.camel.basic.processor;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StringConverterProcessor implements Processor {

	@Value("${conversion}")
	private String conversion;

	@Override
	public void process(Exchange exchange) throws Exception {
		Message m = exchange.getIn();
		Object o = m.getBody();
		String text = "";
		if (o instanceof String) {
			text = o.toString();
		} else if (o instanceof GenericFile) {
			@SuppressWarnings("rawtypes")
			GenericFile f = (GenericFile) o;
			StringBuilder result = new StringBuilder("");
			Files.lines(Paths.get(f.getAbsoluteFilePath())).forEach((s) -> result.append(s));
			text = result.toString();
		}
		text = text.replace(" ", "");
		if ("lower".equals(conversion)) {
			text = text.toLowerCase();
		} else if ("upper".equals(conversion)) {
			text = text.toUpperCase();
		}
		m.setBody(text);

	}

}
