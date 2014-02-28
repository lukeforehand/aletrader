
package com.aletrader.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.scala.DefaultScalaModule;
import com.fasterxml.jackson.databind.SerializationFeature;

// singleton to be used for serializing repository layer or other purposes
object JsonSerializer {

	val mapper = new ObjectMapper();
	mapper.registerModule(DefaultScalaModule);
	mapper.enable(SerializationFeature.INDENT_OUTPUT);

	def serialize(o: Any): String = {
		return mapper.writeValueAsString(o);
	}

	def deserialize[T](o: String, c: Class[T]): T = {
		return mapper.readValue(o, c);
	}

}
