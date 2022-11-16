package org.javacream.training.camel.web;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {

	@Autowired ProducerTemplate template;
	@GetMapping(path = "/toStream")
	public void toStream() {
		template.sendBody("stream:out", "Hello");
	}

	@PostMapping(path = "/toFile")
	public void toFile(@RequestBody String message, @RequestHeader("hugo") int number) {
		template.sendBody("file:result", message);
	}

}
