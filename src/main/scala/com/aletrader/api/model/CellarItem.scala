package com.aletrader.api.model;

import com.aletrader.ws.model.CellarItemRequest;

/*
THIS CLASS WILL EXPAND AS NEEDED

{
	"id": "abc123",
	"beerId": "RVOBIF"
}
*/

class CellarItem(
    val id: String,
	val beerId: String) {
	
	def this(id: String, cellarItemRequest: CellarItemRequest) = this(
		id,
		cellarItemRequest.beerId
	);
}