package org.ericminio.mastermind;

import java.io.IOException;

import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HomePageTest extends WebTester {

	@BeforeClass public void
	herokuHack() {
		MastermindServer.setPortProvider( new PortProvider() {
			@Override
			public Integer getPort() {
				return 8080;
			}
		});
	}
	
	@Before public void
	startServer() throws IOException {
		MastermindServer.main(new String[]{});
	}
	
	@After public void
	stopServer() throws IOException {
		MastermindServer.connection.close();
	}
	
	@Test public void
	welcomeMessage() {
		beginAt("/");
		assertTextPresent( "Mastermind" );
	}

}
