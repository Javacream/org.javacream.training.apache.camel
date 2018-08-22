package org.javacream.training.apache.camel.datatypes;

import java.util.List;

import org.apache.camel.Body;
import org.apache.camel.Handler;

public class DataTypeProcessor {

	@Handler public String process(@Body List<List<String>> data) {
		return data.toString();
	}
}
