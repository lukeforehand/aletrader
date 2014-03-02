
package com.aletrader.api;

import java.util.PropertyResourceBundle;
import java.io.File;
import java.io.FileInputStream;

import org.elasticsearch.client.Client;
import org.elasticsearch.action.admin.cluster.state.ClusterStateResponse;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder._;

import com.aletrader.api.model.CellarItem;
import com.aletrader.brewerydb._;

// this class will eventually become a facade to accessing elasticsearch and postgresql, i.e. data access
class AleTraderRepository(node: Node) {

	// elasticsearch client
	var esClient = node.client();

	var breweryDbClient = new BreweryDBClient(new PropertyResourceBundle(new FileInputStream(new File("/opt/aletrader/brewerydb.properties"))).getString("key"));

	//TODO: add dao layer --> need to choose technology

	def this() = this(nodeBuilder().client(true).build());
	
	
	//
	// Find Beer
	
	def searchUpc(code: String): Beers = {
		return breweryDbClient.searchUpc(code);
	}
	
	def searchBeers(query: String): Beers = {
		// TODO: get Beers from ES based on user query
		return null;
	}
	
	
	//
	// Cellar Item Management
	
	def getCellarItem(cellarItemId: String): CellarItem = {
		// TODO: get Cellar Item from ES
		return new CellarItem("abc123", "Test");
	}
	
	def addCellarItem(cellarItem: CellarItem) {
		// TODO add CellarItem to ES
	}
	
	def updateCellarItem(cellarItem: CellarItem) {
		// TODO update CellarItem to ES
	}
	
	def removeCellarItem(cellarItemId: String) {
		// TODO update CellarItem to no longer be in the current cellar
	}
	
	
	
	// 
	// Verification

	def verifyElasticsearch(): ClusterStateResponse = {
		return esClient.admin().cluster().prepareState().execute().actionGet();
	}

	def verifyBreweryDb(): String = {
		return breweryDbClient.verifyKey();
	}



}