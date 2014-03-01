package com.aletrader.brewerydb;

import org.junit.Test;

import com.aletrader.api.JsonSerializer;

class BreweryClientTest {

	val client = new BreweryDBClient();

	@Test
	def testGetKey() {
		println(client.getKey());
	}

	@Test
	def testVerifyKey() {
		println(client.verifyKey());
	}

	@Test
	def testGetBreweries() {
		var breweries = client.getBreweries(2014);
		breweries.data.foreach(brewery => {
			println(brewery.id);
		});
	}

	@Test
	def testSearchUpc() {
		var beers = client.searchUpc("606905008303");
		beers.data.foreach(beer => {
			println(beer.name);
		});
	}

}
