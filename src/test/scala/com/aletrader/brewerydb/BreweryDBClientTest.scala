package com.aletrader.brewerydb;

import com.aletrader.api.JsonSerializer;

import java.util.PropertyResourceBundle;
import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;

class BreweryClientTest {

	val client = new BreweryDBClient(new PropertyResourceBundle(new FileInputStream(new File("/opt/aletrader/brewerydb.properties"))).getString("key"));

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
		var beers = client.searchUpc("04085645");
		println(beers);
		beers.data.foreach(beer => {
			println(beer.name);
		});
	}

}
