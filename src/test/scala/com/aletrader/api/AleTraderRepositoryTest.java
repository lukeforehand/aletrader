package com.aletrader.api;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.mockito.runners.MockitoJUnitRunner;

import static org.elasticsearch.node.NodeBuilder.*;
import org.elasticsearch.node.Node;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.ImmutableSettings;

import org.elasticsearch.action.admin.cluster.state.ClusterStateResponse;

@RunWith(MockitoJUnitRunner.class)
public class AleTraderRepositoryTest {

	private AleTraderRepository repo;

	private Node node;
	private Client client;

	@Before
	public void before() {
 		node = nodeBuilder().local(true).settings(ImmutableSettings.settingsBuilder().put("path.data", "target").build()).node();
 		client = node.client();
		repo = new AleTraderRepository(client);
	}

	@After
	public void after() {
		repo.destroy();
	}

	@Test
	public void testClusterState() {
		ClusterStateResponse response = repo.clusterState();
		System.out.println(response.getClusterName() + "->" + response.getState());
		
	}

}