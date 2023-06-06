package com.springcore.controller;


import com.springcore.model.Address;
import com.springcore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.AddressBody;

import java.util.List;

@RestController
@RequestMapping("api/address")

public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/")
    @CrossOrigin(origins = "*" , allowedHeaders = "*")
    public ResponseEntity<Address> createAddress(@RequestBody AddressBody addressBody){

        Address address = this.addressService.saveAddress(addressBody);
        return  new ResponseEntity<>(address , HttpStatus.CREATED);
  }

    @GetMapping("/usersaddresses/{userId}")
    @CrossOrigin
    public ResponseEntity<List<Address>> getAllAddressesByUser(@PathVariable Integer userId){
        List<Address> addresses = addressService.getAllAddressByUser(userId);
        return ResponseEntity.ok(addresses);
    }

    @DeleteMapping("/{addressId}")
    @CrossOrigin
    public ResponseEntity<String> deleteAddress(@PathVariable Integer addressId){
        this.addressService.DeleteAddress(addressId);
        return ResponseEntity.ok("success");
    }


}
