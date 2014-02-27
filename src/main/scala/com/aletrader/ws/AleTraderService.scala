package com.aletrader.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

@Component
@Path("/")
class AleTraderService {

	@GET
	@Path("/ping")
	@Produces(Array("text/plain"))
	def ping(): String = {
		return "pong";
	}


}