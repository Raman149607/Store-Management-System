package com.storedetails.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.storedetails.api.model.Address;
import com.storedetails.api.model.StoreDetails;

@Repository
public interface StoreDetailsRepository extends MongoRepository<StoreDetails, String> {

	List<Address> findByPinCode(Address address);

}
