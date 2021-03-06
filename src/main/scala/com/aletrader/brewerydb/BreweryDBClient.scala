package com.aletrader.brewerydb;

import org.glassfish.jersey.client.ClientConfig;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider; 
import com.aletrader.api.JsonSerializer;

class BreweryDBClient(val key: String) {

	val baseUri = "http://api.brewerydb.com/v2/%s/?key=" + key;

	val config = new ClientConfig(new JacksonJsonProvider(JsonSerializer.mapper));

	var client = ClientBuilder.newClient(config);

	def getKey(): String = {
		return key;
	}

	def verifyKey(): String = {
		return client
			.target(String.format(baseUri, ""))
			.request(MediaType.TEXT_PLAIN).get()
			.readEntity(classOf[String]);
	}

	def getBreweries(yearEstablished: Int): Breweries = {
		return client
			.target(String.format(baseUri, "breweries") + "&established=" + yearEstablished)
			.request(MediaType.APPLICATION_JSON).get()
			.readEntity(classOf[Breweries]);
	}

	def searchUpc(code: String): Beers = {
		return client
			.target(String.format(baseUri, "search/upc") + "&code=" + code)
			.request(MediaType.APPLICATION_JSON).get()
			.readEntity(classOf[Beers]);
	}

}
