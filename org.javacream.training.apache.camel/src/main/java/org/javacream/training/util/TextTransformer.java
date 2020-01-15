package org.javacream.training.util;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class TextTransformer {
	private Map<String, Function<String, String>>algorithms;

	{
		algorithms = new HashMap<>();
		algorithms.put("upper", (String s) -> {return s.toUpperCase();});
		algorithms.put("lower", (String s) -> {return s.toLowerCase();});
	}
	public String transform(String algorithmName, String input) {
		return algorithms.get(algorithmName).apply(input);
	}

}
