package org.ericminio.mastermind;

public class HerokuPortProvider implements PortProvider {

	@Override
	public Integer getPort() {
		return Integer.valueOf(System.getenv("PORT"));
	}

}
