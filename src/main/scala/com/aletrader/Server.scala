package com.aletrader;

import org.eclipse.jetty.server._;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.webapp.WebAppContext;

object Server {

	def main(args: Array[String]) {
		
		if (args.length < 3) {
			System.err.println("requires three parameters, port, contextPath, warPath");
			System.exit(1);
		}
		var port: Int = new Integer(args(0));
		var contextPath: String = args(1);
		var warPath: String = args(2);
		
		init(port, contextPath, warPath);

	}
	
	def init(port: Int, contextPath: String, warPath: String) {
		
		var server: org.eclipse.jetty.server.Server = new org.eclipse.jetty.server.Server();
		var connector: SocketConnector = new SocketConnector();
		connector.setPort(port);
		server.setConnectors(Array(connector));

		var bb: WebAppContext = new WebAppContext();
		bb.setServer(server);
		bb.setContextPath(contextPath);
		bb.setWar(warPath);

		server.setHandler(bb);
		server.start();
		server.join();
	}
	
}
