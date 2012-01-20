package org.ericminio.mastermind.http;

public class PORTSystemEnvReader implements PortProvider {

	@Override
	public Integer getPort() {
		return Integer.valueOf(System.getenv("PORT"));
	}

}
