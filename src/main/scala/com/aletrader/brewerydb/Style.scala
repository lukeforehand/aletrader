package com.aletrader.brewerydb;
/*
{
	"id": 30,
	"category": {
	    "id": 3,
	    "createDate": "2012-03-21 20:06:45",
	    "name": "North American Origin Ales"
	},
	"srmMax": "14",
	"ibuMax": "70",
	"srmMin": "6",
	"description": "American-style India pale ales are perceived to have medium-high to intense hop bitterness, flavor and aroma with medium-high alcohol content. The style is further characterized by floral, fruity, citrus-like, piney, resinous, or sulfur-like American-variety hop character. Note that one or more of these American-variety hop characters is the perceived end, but the hop characters may be a result of the skillful use of hops of other national origins. The use of water with high mineral content results in a crisp, dry beer. This pale gold to deep copper-colored ale has a full, flowery hop aroma and may have a strong hop flavor (in addition to the perception of hop bitterness). India pale ales possess medium maltiness which contributes to a medium body. Fruity-ester flavors and aromas are moderate to very strong. Diacetyl can be absent or may be perceived at very low levels. Chill and/or hop haze is allowable at cold temperatures. (English and citrus-like American hops are considered enough of a distinction justifying separate American-style IPA and English-style IPA categories or subcategories. Hops of other origins may be used for bitterness or approximating traditional American or English character. See English-style India Pale Ale",
	"fgMin": "1.012",
	"ibuMin": "50",
	"createDate": "2012-03-21 20:06:45",
	"fgMax": "1.018",
	"abvMax": "7.5",
	"ogMin": "1.06",
	"abvMin": "6.3",
	"name": "American-Style India Pale Ale",
	"categoryId": 3
}
*/

class Style(
	val id: Int,
	val category: Category,
	val srmMax: String,
	val ibuMax: String,
	val srmMin: String,
	val description: String,
	val fgMin: String,
	val ibuMin: String,
	val createDate: String,
	val fgMax: String,
	val abvMax: String,
	val ogMin: String,
	val abvMin: String,
	val name: String,
	val categoryId: Int) {}
