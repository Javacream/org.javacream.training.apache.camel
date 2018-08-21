package org.javacream.training.apache.camel.complexfile;

import org.apache.camel.Body;
import org.apache.camel.Handler;
import org.apache.camel.Header;
import org.javacream.training.util.TextTransformer;

public class ContentProcessor{

	private TextTransformer transformer;

	public void setTransformer(TextTransformer transformer) {
		this.transformer = transformer;
	}

	@Handler
	public String processTransform(@Header("javacream.txt.algorithm") String algorithm, @Body String input) throws Exception {
		return transformer.transform(algorithm, input);

	}

}
