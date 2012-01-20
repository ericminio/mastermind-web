package org.ericminio.mastermind;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.ericminio.mastermind.http.PORTSystemEnvReader;
import org.ericminio.mastermind.http.PortProvider;
import org.junit.Test;

public class MastermindServerTest {

	@Test public void
	defaultPortProviderIsHerokuOne() {
		assertThat( MastermindServer.portProvider, instanceOf( PORTSystemEnvReader.class ) ) ;
	}
	
	@Test public void
	defaultPortProviderCanBeOverridenStatically() {
		PortProvider dummy = dummy();
		MastermindServer.portProvider = dummy;
		assertThat( MastermindServer.portProvider, equalTo( dummy ));
	}

	protected PortProvider dummy() {
		PortProvider dummy = new PortProvider() {
			@Override
			public Integer getPort() {
				return null;
			}
		};
		return dummy;
	}

}
