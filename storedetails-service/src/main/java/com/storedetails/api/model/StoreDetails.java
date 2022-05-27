package com.storedetails.api.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;


public class StoreDetails {

	private ObjectId id;
	@NotBlank(message = "Store Name cannot be Blank")
	private String storeName;
	@Min(value = 10,message = "Length Of Phone Number Should not be less than 10 and more than 11")
	private long phone;
	@NotEmpty
	@Size(min=5)
	@Email
	private String email;
	@Valid
	private List<Address> addresses;


	

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public String getId() {
		return id.toHexString();
	}

	public void setId(ObjectId id) {
		this.id = id;
	}


	

}
