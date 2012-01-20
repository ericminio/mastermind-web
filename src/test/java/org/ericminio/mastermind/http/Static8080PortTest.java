package org.ericminio.mastermind.http;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Static8080PortTest {

	@Test
	public void portIs8080() {
		assertThat( new Static8080Port().getPort(), equalTo( 8080 ));
	}

}
