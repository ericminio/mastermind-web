package org.ericminio.mastermind;

import java.io.IOException;

import net.sourceforge.jwebunit.junit.WebTester;

import org.ericminio.mastermind.MastermindServer;
import org.ericminio.mastermind.http.Static8080Port;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MastermindTest extends WebTester {

	@Before public void
	startServer() throws IOException {
		MastermindServer.portProvider = new Static8080Port();
		MastermindServer.main(new String[]{});
	}
	
	@After public void
	stopServer() throws IOException {
		MastermindServer.stop();
	}
	
	@Test public void
	welcomeMessage() {
		beginAt("/");
		assertTextPresent( "Mastermind" );
	}

}
