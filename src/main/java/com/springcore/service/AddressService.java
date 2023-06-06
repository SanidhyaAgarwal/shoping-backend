package com.springcore.service;

import java.util.List;

import com.springcore.model.Address;

import org.springframework.stereotype.Service;
import utils.AddressBody;


public interface AddressService {

	Address saveAddress(AddressBody addressBody);
	List<Address> getAllAddressByUser(Integer userId);

	void DeleteAddress(Integer id);


	// delete add
}
