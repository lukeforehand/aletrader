package com.aletrader.brewerydb;

/*
{
	"id": "RVOBIF",
	"abv": "8",
	"description": "Enjoy the clover honey hue and tropical nose. Simultaneously Punchy and soothing with a big body and a finish that boasts pineapple and grapefruit. Flower power is hopped and dry-hopped five different times throughout the brewing and fermentation process.",
	"statusDisplay": "Verified",
	"foodPairings": "Accentuates hot and spicy cuisine like Indian and Thai curries or Mexican.\r\n\r\nStrong cheeses like Stilton, Danish Blue or Gorgonzola.",
	"glass": {
	    "id": 5,
	    "createDate": "2012-01-03 02:41:33",
	    "name": "Pint"
	},
    "srm":{
        "id":41,
        "name":"Over 40",
       "hex":"000000"
    },
	"style": {
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
	},
	"createDate": "2012-01-03 02:43:13",
	"labels": {
	    "medium": "http://s3.amazonaws.com/",
	    "large": "http://s3.amazonaws.com/",
	    "icon": "http://s3.amazonaws.com/"
	},
	"srmId": 1,
	"availableId": 4,
	"styleId": 30,
	"updateDate": "2012-03-22 13:05:03",
	"ibu": "75",
	"glasswareId": 5,
	"available": {
	    "id": "4",
	    "description": "Available at the same time of year, every year.",
	    "name": "Seasonal"
	},
	"isOrganic": "N",
	"fluidSize": {
	    "volume": "pack",
	    "quantity": "6",
	    "id": 6,
	    "volumeDisplay": "Pack",
	    "createDate": "2012-01-03 02:41:33"
	},
	"status": "verified",
	"name": "Flower Power"
}
*/

class Beer(
	val id: String,
	val abv: String,
	val description: String,
	val statusDisplay: String,
	val foodPairings: String,
	val glass: Glass,
	val srm: Srm,
	val style: Style,
	val createDate: String,
	val labels: Images,
	val srmId: Int,
 	val availableId: Int,
 	val styleId: Int,
 	val updateDate: String,
 	val ibu: String,
 	val glasswareId: Int,
 	val available: Available,
	val isOrganic: String,
	val fluidSize: FluidSize,
	val status: String,
	val name: String) {}
