package com.aletrader.brewerydb;

/*
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
}
*/

class Brewery(
	val id: String,
	val description: String,
	val name: String,
	val createDate: String,
	val mailingListUrl: String,
	val updateDate: String,
	val images: Images,
	val established: String,
	val isOrganic: String,
	val website: String,
	val status: String,
	val statusDisplay: String) {}

