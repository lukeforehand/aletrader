package com.aletrader.ws;

import com.aletrader.api.model.TestModel;

import javax.ws.rs.core.MediaType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

@Component
@Path("/")
class AleTraderService { //TODO: extract from this an interface under the api package

	@GET
	@Path("/ping")
	@Produces(Array(MediaType.TEXT_PLAIN))
	def ping(): String = {
		return "pong";
	}

	@GET
	@Path("/test")
	@Produces(Array(MediaType.APPLICATION_JSON))
	def test(): TestModel = {
		return new TestModel("test");
	}

}