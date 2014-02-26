
package com.aletrader.api;

import java.util.ResourceBundle;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.action.admin.cluster.state.ClusterStateResponse;

// this class will eventually become a facade to accessing elasticsearch and postgresql, i.e. data access
class AleTraderRepository(client: Client) {

	def this() = this(new TransportClient().addTransportAddress(new InetSocketTransportAddress(ResourceBundle.getBundle("application").getString("es.host"), 9300)));

	def destroy() {
		client.close();
	}

	def clusterState(): ClusterStateResponse = {
		return client.admin().cluster().prepareState().execute().actionGet();
	}

}