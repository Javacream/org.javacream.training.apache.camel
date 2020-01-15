package org.javacream.training.demo;

import org.javacream.training.echo.EchoBusiness;

public class DemoBusiness {

	private EchoBusiness echoBusiness;

	public void setEchoBusiness(EchoBusiness echoBusiness) {
		this.echoBusiness = echoBusiness;
	}
	
	public void doSomething() {
		//...
		System.out.println(echoBusiness.echo2("Hello"));
	}
}
