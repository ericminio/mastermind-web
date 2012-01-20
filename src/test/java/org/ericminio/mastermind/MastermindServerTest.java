package org.ericminio.mastermind;


import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MastermindServerTest {

	MastermindServer server;
	
	@Before public void
	init() {
		server = new MastermindServer();
	}
	
	@SuppressWarnings("static-access")
	@Test public void
	defaultPortProviderIsHerokuOne() {
		assertThat( server.portProvider, instanceOf( HerokuPortProvider.class ) ) ;
	}

}
