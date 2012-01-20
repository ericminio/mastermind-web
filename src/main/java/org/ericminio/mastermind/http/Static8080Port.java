package org.ericminio.mastermind.http;

public class Static8080Port implements PortProvider {

	@Override
	public Integer getPort() {
		return 8080;
	}

}
