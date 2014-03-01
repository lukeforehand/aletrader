
package com.aletrader.brewerydb;

/*
{
    "status": "success",
    "numberOfPages": 1,
    "data": [
        [
            {... beer ...}
        ]
    ],
    "currentPage": 1
}
*/

class Beers(
    val status: String,
    val numberOfPages: Int,
    val data: Array[Beer],
    val currentPage: Int,
    val totalResults: Int) {}
