package com.instamint.services.ds;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.Data;

import java.util.Map;

@Data
public class Request {
    @JsonbProperty("issuerID") private String issuerID;
    @JsonbProperty("chain") private String chain;
    @JsonbProperty("env") private String env;
    @JsonbProperty("linger") private Integer linger;
    @JsonbProperty("contract") private String contract;
    @JsonbProperty("b2bCrossReferenceID") private String b2bCrossReferenceID;
    @JsonbProperty("strategy") private String strategy;
    @JsonbProperty("assetTypeID") private String assetTypeID;
    @JsonbProperty("storage") private String storage;

    @JsonbProperty("asset") private Map asset;
    @JsonbProperty("references") private Map references;

}

/*

{
	"issuerID": "959980e5ff59427AbbC54c59FfF22809",
	"assetID": "assetid321",
	"command": "mint",
	"chain": "ethereum",
	"env": "testnet",
	"linger": "86400",
	"contract": "INSTA1",
	"b2bCrossReferenceID": "4230402830",
	"strategy": "real",
	"assetTypeID": "J1234",
	"asset": {
		"maturityDate": "11/1/2068",
		"serialNumber": "A12345"
	},
	"references": {
		"image": "https://s3-prod-europe.autonews.com/s3fs-public/styles/1200x630/public/Lamborghini%20Huracan%20STO%20web.jpg"
	},
	"storage": "ipfs",
	"fractionalization": "0",
	"royalties": {
		"scheme": "standard"
	},
	"chainSpecific": {

	}
}

 */
