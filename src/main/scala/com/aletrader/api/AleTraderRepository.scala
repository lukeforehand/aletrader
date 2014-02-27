
package com.aletrader.api;

import com.aletrader.cellar.label.LabelGenerator;

import java.util.ResourceBundle;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.action.admin.cluster.state.ClusterStateResponse;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder._;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

// this class will eventually become a facade to accessing elasticsearch and postgresql, i.e. data access
@Component
class AleTraderRepository(node: Node) {

	// elasticsearch client
	var es = node.client();

	// label generator
	var labels = LabelGenerator;

	//TODO: add dao layer --> need to choose technology

	def this() = this(nodeBuilder().client(true).build());

	def clusterState(): ClusterStateResponse = {
		return es.admin().cluster().prepareState().execute().actionGet();
	}

}