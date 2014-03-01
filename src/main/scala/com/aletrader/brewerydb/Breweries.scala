package com.aletrader.brewerydb;

/*

{
  "status" : "success",
  "numberOfPages" : 63,
  "data" : [
    {
      "id" : "KlSsWY",
      "description" : "",
      "name" : "'t Hofbrouwerijke",
      "createDate" : "2012-01-02 11:50:52",
      "mailingListUrl" : "",
      "updateDate" : "",
      "images" : {
        "medium" : "",
        "large" : "",
        "icon" : ""
      },
      "established" : "",
      "isOrganic" : "N",
      "website" : "http://www.thofbrouwerijke.be/",
      "status" : "verified",
      "statusDisplay" : "Verified"
    },
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

