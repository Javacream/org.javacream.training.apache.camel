package org.javacream.training.util;

public class TextTransformer {
	private String algorithm;

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	public String transform(String input) {
		String result = input;
		if ("upper".equals(algorithm)) {
			result = input.toUpperCase();
		} else if ("lower".equals(algorithm)) {
			result = input.toLowerCase();
		}
		return result;
	}

}
