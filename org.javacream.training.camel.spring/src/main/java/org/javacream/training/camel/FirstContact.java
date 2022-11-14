package org.javacream.training.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstContact {
	public static void main(String[] args) throws Exception{
		System.out.println("Starting main...");
		SpringApplication.run(FirstContact.class, args);
		Thread.sleep(5000);
		System.exit(0);
	}
}
