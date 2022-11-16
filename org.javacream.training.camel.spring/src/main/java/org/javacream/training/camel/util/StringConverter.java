package org.javacream.training.camel.util;

import org.springframework.stereotype.Component;

@Component
public class StringConverter{


	public String transform(String s){
		return s.replace(" ", "");
	}

}
