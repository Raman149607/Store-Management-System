package com.storedetails.api.dto;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.storedetails.api.model.StoreDetails;

@Document(collection = "StoreDetails")
public class StoreDetailsDTO extends StoreDetails{
	
	@Id
	private ObjectId id;

}
