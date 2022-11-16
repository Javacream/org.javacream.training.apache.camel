package org.javacream.training.camel;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.apache.camel.test.spring.junit5.MockEndpointsAndSkip;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@CamelSpringBootTest
//@MockEndpoints("stream:out")
@MockEndpointsAndSkip("file:out")
@SpringBootTest
public class DirectDemoRouteTest {

	@Autowired ProducerTemplate producerTemplate;
	@EndpointInject("mock:file:out") MockEndpoint mock;
	@Test public void testSimple() throws Exception{
		mock.expectedBodiesReceived("hello", "helloworld");
		producerTemplate.sendBodyAndHeader("direct:demo", "Hello", "to", "file:out");
		producerTemplate.sendBodyAndHeader("direct:demo", "He Ll o    WOR ld", "to", "file:out");
		mock.assertIsSatisfied();
	}
	

}
