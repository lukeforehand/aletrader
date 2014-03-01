package com.aletrader.brewerydb;

/*

{
  "status" : "success",
  "numberOfPages" : 63,
  "data" : [
    {...brewery...},
    ...
  ],
  "currentPage" : 1,
  "totalResults": 109
}
*/

class Breweries(
	val status: String,
	val numberOfPages: Int,
	val data: Array[Brewery],
	val currentPage: Int,
	val totalResults: Int) {}

