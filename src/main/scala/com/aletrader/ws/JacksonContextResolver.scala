package com.aletrader.ws;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.Produces
import scala.Array
import javax.ws.rs.core.MediaType
import com.aletrader.api.JsonSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;

// this class should provide an object mapper to jersey
@Provider
@Produces(Array(MediaType.APPLICATION_JSON))
class JacksonContextResolver extends ContextResolver[ObjectMapper] {
  def getContext(clazz: Class[_]) = JsonSerializer.mapper
}
