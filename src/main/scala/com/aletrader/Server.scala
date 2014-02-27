package com.aletrader;

import org.eclipse.jetty.server._;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.webapp.WebAppContext;

// must be object to invoke main method
object Server {

	def main(args: Array[String]) {
		
		if (args.length < 3) {
			System.err.println("requires three parameters, port, contextPath, warPath");
			System.exit(1);
		}
		var port = new Integer(args(0));
		var contextPath = args(1);
		var warPath = args(2);
		
		init(port, contextPath, warPath);

	}
	
	def init(port: Int, contextPath: String, warPath: String) {
		
		var server  = new org.eclipse.jetty.server.Server();
		var connector = new SocketConnector();
		connector.setPort(port);
		server.setConnectors(Array(connector));

		var bb = new WebAppContext();
		bb.setServer(server);
		bb.setContextPath(contextPath);
		bb.setWar(warPath);

		server.setHandler(bb);
		server.start();
		server.join();
	}
	
}
