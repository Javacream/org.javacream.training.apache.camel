package org.javacream.training.apache.camel.datatypes;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.camel.Converter;
import org.apache.camel.TypeConverters;

public class DataTypeConverter implements TypeConverters{

	@Converter public InputStream convertFromListToString(ArrayList data) {
		return null;
	}
}
