package org.javacream.training.apache.camel.complexfile;

import org.apache.camel.CamelContext;
import org.apache.camel.Produce;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(CamelSpringJUnit4ClassRunner.class)
@ContextConfiguration("complexfile-route.xml")
public class SimpleCamelTest {
	@Autowired private CamelContext camelContext;

}
