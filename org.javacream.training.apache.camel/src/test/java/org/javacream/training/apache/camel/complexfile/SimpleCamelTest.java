package org.javacream.training.apache.camel.complexfile;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.apache.camel.test.spring.MockEndpointsAndSkip;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(CamelSpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:complexfile-route.xml")
@MockEndpointsAndSkip("direct:textProcessed")
public class SimpleCamelTest{
	
	@Autowired
	private CamelContext camelContext;

	@Produce(uri = "direct:textProcessing")
	private ProducerTemplate producerTemplate;

	@EndpointInject(uri="mock:direct:textProcessed")
	private MockEndpoint endpoint;
	
	@Test
	public void testDirectRoute() throws Exception{
		endpoint.expectedBodiesReceived("HUGO");
		producerTemplate.sendBody("hugo");
		endpoint.assertIsSatisfied();
	}
}
