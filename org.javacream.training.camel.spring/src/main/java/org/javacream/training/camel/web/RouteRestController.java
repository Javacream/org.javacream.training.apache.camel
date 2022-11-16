package org.javacream.training.camel.web;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteRestController {

	@Autowired ProducerTemplate template;

	@PostMapping(path = "/callDemoRoute")
	public void demoRoute(@RequestBody String message, @RequestHeader("destination") String destination) {
		template.sendBodyAndHeader("direct:demo", message, "to", destination);
	}
	@PostMapping(path = "/callComplexRoute")
	public void complexRoute(@RequestBody String message) {
		template.sendBody("direct:in", message);
	}

}
