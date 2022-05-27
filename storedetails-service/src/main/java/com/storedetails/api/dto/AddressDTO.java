package com.storedetails.api.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import com.storedetails.api.model.Address;

@Document(collection = "adddress")
public class AddressDTO extends Address{

}
