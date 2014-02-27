package com.aletrader.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

@Component
class AleTraderService {

	@GET
	@Path("/ping")
	def ping(): String = {
		return "pong";
	}


}