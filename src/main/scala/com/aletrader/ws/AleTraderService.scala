package com.aletrader.ws;

import com.aletrader.api.AleTraderRepository;
import com.aletrader.brewerydb._;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/")
class AleTraderService { //TODO: extract from this an interface under the api package

	var repo = new AleTraderRepository();

	@GET
	@Path("/ping")
	@Produces(Array(MediaType.TEXT_PLAIN))
	def ping(): String = {
		return "pong";
	}

	@GET
	@Path("/upc/{code}")
	@Produces(Array(MediaType.APPLICATION_JSON))
	def searchUpc(@PathParam("code") code: String): Beers = {
		return repo.searchUpc(code);
	}

}