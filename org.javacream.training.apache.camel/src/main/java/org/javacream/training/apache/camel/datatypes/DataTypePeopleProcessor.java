package org.javacream.training.apache.camel.datatypes;

import java.util.List;

import org.apache.camel.Body;
import org.apache.camel.Handler;

public class DataTypePeopleProcessor {

	@Handler public String process(@Body List<Person> data) {
	return data.toString();
	}
}
