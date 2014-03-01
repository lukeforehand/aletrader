package com.aletrader.brewerydb;

import org.junit.Test;

class BreweryClientTest {

	val client = new BreweryClient();

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

}
