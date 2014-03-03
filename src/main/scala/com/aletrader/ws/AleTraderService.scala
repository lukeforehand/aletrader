package com.aletrader.ws;

import com.aletrader.api.AleTraderRepository;
import com.aletrader.api.model.CellarItem;
import com.aletrader.brewerydb._;
import com.aletrader.ws.model.CellarItemRequest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


// make @Singleton to avoid instantiation of the repo every time
@Path("/")
class AleTraderService { //TODO: extract from this an interface under the api package

	var repo = new AleTraderRepository();

	@GET
	@Path("/ping")
	@Produces(Array(MediaType.TEXT_PLAIN))
	def ping(): String = {
		return "pong";
	}


	//
	// Cellar Management
	
	@PUT
	@Path("/cellar/{cellarId}/{cellarItemId}") 
	@Consumes(Array(MediaType.APPLICATION_JSON))
	def putCellarItem(@PathParam("cellarId") cellarId: Int, 
					  @PathParam("cellarItemId") cellarItemId: String,
					  cellarItemRequest: CellarItemRequest) {
		
		var cellarItem = new CellarItem(cellarItemId, cellarItemRequest);
		
		if(repo.getCellarItem(cellarItemId) != null) {
			repo.updateCellarItem(cellarItem);
		} else {
			repo.addCellarItem(cellarItem);
		}
	}
	
	@DELETE
	@Path("/cellar/{cellarId}/{cellarItemId}") 
	def deleteCellarItem(@PathParam("cellarId") cellarId: Int, 
						 @PathParam("cellarItemId") cellarItemId: String) {
		repo.removeCellarItem(cellarItemId);
	}

	
	//
	// Find beer
	
	@GET
	@Path("/upc/{code}")
	@Produces(Array(MediaType.APPLICATION_JSON))
	def searchUpc(@PathParam("code") code: String): Beers = {
		return repo.searchUpc(code);
	}
	
	// This is to query a beer without UPC
	@GET
	@Path("/search")  // Eventually this could be become /search/{type}
	@Produces(Array(MediaType.APPLICATION_JSON))
	def productSearch(@QueryParam("q") beerQuery: String): Beers = {
		return repo.searchBeers(beerQuery);
	}

}