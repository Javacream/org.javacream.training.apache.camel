package org.javacream.training.apache.camel.demo;

import org.apache.camel.Body;
import org.apache.camel.CamelContext;
import org.apache.camel.Header;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.ProxyBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class TemplateAndProxy 
{
	public static void main(String[] args) throws Exception 
	{
		new TemplateAndProxy();
	}
	
	private CamelContext context;
	
	public TemplateAndProxy() throws Exception
	{
		context = new DefaultCamelContext();
		context.start();
		withProducer();
		withProxy();
	}
	
	private void withProducer() throws Exception
	{
		ProducerTemplate producerTemplate = context.createProducerTemplate();
		producerTemplate.sendBodyAndHeader("file://outdir", "Hello from ProducerTemplate", "CamelFileName", "ProducerTemplate.txt");
	}
	
	
	private void withProxy() throws Exception
	{
		DemoWriter writer = new ProxyBuilder(context).endpoint("file://outdir").build(DemoWriter.class);
		writer.write("Proxy.txt", "Hello from Proxy");
	}
	
	 interface DemoWriter
	 {
	        public void write(@Header("CamelFileName") String fileName, @Body String content);
	 }
	
	
	

}
