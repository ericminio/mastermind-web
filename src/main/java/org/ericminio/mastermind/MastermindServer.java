package org.ericminio.mastermind;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

import org.ericminio.mastermind.http.PORTSystemEnvReader;
import org.ericminio.mastermind.http.PortProvider;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.simpleframework.transport.connect.SocketConnection;

public class MastermindServer implements Container {

	static SocketConnection connection;
	public static PortProvider portProvider = new PORTSystemEnvReader();

	public static void main(String[] args) throws IOException {
		Container container = new MastermindServer();
		connection = new SocketConnection( container );
		SocketAddress address = new InetSocketAddress( portProvider.getPort() );
		connection.connect( address );
	}

	public static void stop() throws IOException {
		connection.close();
	}

	@Override
	public void handle(Request request, Response response) {
		try {
			PrintStream body = response.getPrintStream();
			long time = System.currentTimeMillis();

			response.set( "Content-Type", "text/html" );
			response.set( "Server", "Mastermind/1.0 (Simple 4.0)" );
			response.setDate( "Date", time );
			response.setDate( "Last-Modified", time );

			body.append( "Mastermind" );
			body.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
