package com.springcore.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcore.model.Address;
import com.springcore.model.Users;
import com.springcore.repository.AddressRepository;
import com.springcore.repository.UserRepository;
import com.springcore.service.AddressService;

import utils.AddressBody;


@Service
public class AddressServiceImpl implements AddressService{

	
	@Autowired
	private UserRepository userRepository;
	private AddressRepository addressRepository;
	
	
	@Autowired
	private AddressServiceImpl(AddressRepository addressRepository) {
		this.addressRepository=addressRepository;
	}
	
	@Override
	public Address saveAddress(AddressBody addressBody) {
		Users user =this.userRepository.findById(addressBody.getUserId()).orElseThrow();
		Address address=new Address();
		address.setUser(user);
		address.setAddressCity(addressBody.getAddressCity());
		address.setAddressCountry(addressBody.getAddressCountry());
		address.setAddressLine(addressBody.getAddressLine());
		address.setAddressPinCode(addressBody.getAddressPinCode());
		address.setAddressState(addressBody.getAddressState());
		Address newAddress=this.addressRepository.save(address);
		return newAddress;
		
	}

	@Override
	public List<Address> getAllAddressByUser(Integer userId) {
		Users user =this.userRepository.findById(userId).orElseThrow();

		List<Address> address=this.addressRepository.findByUser(user);
		return address;
	}

	@Override
	public void DeleteAddress(Integer id) {
		Address address=this.addressRepository.findById(id).orElseThrow();
		this.addressRepository.delete(address);
	}

	
}
