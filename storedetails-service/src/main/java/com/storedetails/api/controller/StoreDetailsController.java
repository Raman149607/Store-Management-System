package com.storedetails.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storedetails.api.model.StoreDetails;
import com.storedetails.api.services.StoreDetailsService;

@RestController
@RequestMapping("/api")
public class StoreDetailsController {

	@Autowired
	StoreDetailsService storeDetailsService;

	@PostMapping("/StoreDetails")
	public ResponseEntity<String> createProduct(@Valid @RequestBody StoreDetails storeDetails) {

		try {
			storeDetailsService.saveStoreDetails(storeDetails);
			return ResponseEntity.status(HttpStatus.CREATED).body("StoreDetails Added Successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("StoreDetails Cannot Be added");
		}
	}

	@GetMapping("/StoreDetails")
	public ResponseEntity<List<StoreDetails>> getAllProducts() {
		try {
			List<StoreDetails> storeDetails = new ArrayList<>();
			storeDetailsService.getStoreDetails().forEach(storeDetails::add);

			if (storeDetails.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			return new ResponseEntity<>(storeDetails, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/StoreDetails/{id}")
	public ResponseEntity<StoreDetails> getProductById(@PathVariable("id") String id) {
		Optional<StoreDetails> storeData = storeDetailsService.storeDetailsById(id);
		if (storeData.isPresent()) {
			return new ResponseEntity<>(storeData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{zipCode}")
	public ResponseEntity<List<StoreDetails>> getStoreDetailsByZipCode(@PathVariable int zipCode) {
		
		List<StoreDetails> storeData = new ArrayList<>();
		storeDetailsService.storeDetailsByZipCode(zipCode).forEach(storeData::add);
		if (!storeData.isEmpty()) {
			return new ResponseEntity<>(storeData, HttpStatus.OK);

		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
