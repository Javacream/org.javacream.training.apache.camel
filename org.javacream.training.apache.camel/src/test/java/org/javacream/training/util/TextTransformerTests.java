package org.javacream.training.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:business.xml")
public class TextTransformerTests {

	@Autowired
	private TextTransformer transformer;
	
	@Test public void testUpperTransform() {
		transformer.setAlgorithm("upper");
		final String IN = "Hugo";
		final String EXPECTED = "HUGO";
		String result = transformer.transform(IN);
		Assert.assertEquals(EXPECTED, result);
	}
	@Test public void testLowerTransform() {
		transformer.setAlgorithm("lower");
		final String IN = "Hugo";
		final String EXPECTED = "hugo";
		String result = transformer.transform(IN);
		Assert.assertEquals(EXPECTED, result);
	}
	
	@Test public void testSpringConfiguration() {
		final String IN = "Hugo";
		final String EXPECTED = "HUGO";
		String result = transformer.transform(IN);
		Assert.assertEquals(EXPECTED, result);
	}

}
