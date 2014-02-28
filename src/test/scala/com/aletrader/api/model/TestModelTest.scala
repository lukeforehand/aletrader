
package com.aletrader.api.model;

import com.aletrader.api.JsonSerializer;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.scala.DefaultScalaModule;
import com.fasterxml.jackson.databind.SerializationFeature;

// test model serialization deserialization with jackson
class TestModelTest {

	// serialize a model, deserialize, serialize again, to print out the final result to prove its working
	@Test
	def test() {
		println(
			JsonSerializer.serialize(
				JsonSerializer.deserialize(
					JsonSerializer.serialize(
						new TestModel("field1")), classOf[TestModel])));
	}

}