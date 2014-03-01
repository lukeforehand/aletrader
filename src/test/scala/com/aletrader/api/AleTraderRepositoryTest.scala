package com.aletrader.api;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.mockito.runners.MockitoJUnitRunner;

import org.elasticsearch.node.NodeBuilder._;
import org.elasticsearch.node.Node;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.ImmutableSettings;

import org.elasticsearch.action.admin.cluster.state.ClusterStateResponse;

@RunWith(classOf[MockitoJUnitRunner])
class AleTraderRepositoryTest {

	var node: Node = _;
	var repo: AleTraderRepository = _;

	@Before
	def before() {
		node = nodeBuilder().local(true).settings(ImmutableSettings.settingsBuilder().put("path.data", "target").build()).node();
		repo = new AleTraderRepository(node);
	}

	@After
	def after() {
		node.close();
	}

	@Test
	def testSearchUpc() {
		println(repo.searchUpc("606905008303"));
	}

}