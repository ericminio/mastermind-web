package org.ericminio.mastermind;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

import org.apache.commons.io.FileUtils;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.simpleframework.transport.connect.SocketConnection;

public class MastermindServer implements Container {

	static SocketConnection connection;

	public static void main(String[] args) throws IOException {
		Container container = new MastermindServer();
		connection = new SocketConnection( container );
		SocketAddress address = new InetSocketAddress( 8080 );
		connection.connect( address );
	}

	@Override
	public void handle(Request request, Response response) {
		try {
			PrintStream body = response.getPrintStream();
			long time = System.currentTimeMillis();

			response.set( "Content-Type", "text/html" );
			response.set( "Server", "HelloWorld/1.0 (Simple 4.0)" );
			response.setDate( "Date", time );
			response.setDate( "Last-Modified", time );

			String html = FileUtils.readFileToString(new File("index.html"));
			body.append( html );
			body.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
