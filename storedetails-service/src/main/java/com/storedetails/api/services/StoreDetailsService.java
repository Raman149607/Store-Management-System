package com.storedetails.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storedetails.api.model.Address;
import com.storedetails.api.model.StoreDetails;
import com.storedetails.api.repository.StoreDetailsRepository;

@Service
public class StoreDetailsService {

	@Autowired
	StoreDetailsRepository detailsRepository;

	public StoreDetails saveStoreDetails(StoreDetails storeDetails) {

		return detailsRepository.insert(storeDetails);

	}

	public List<StoreDetails> getStoreDetails() {
		return detailsRepository.findAll();
	}

	public Optional<StoreDetails> storeDetailsById(String id) {
		return detailsRepository.findById(id);
	}

	public List<Address> storeDetailsByPinCode(int pinCode) {
		Address address = new Address();
		address.setPinCode(pinCode);
		return detailsRepository.findByPinCode(address);

	}

}
