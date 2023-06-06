package com.springcore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcore.model.Address;
import com.springcore.model.Users;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
List<Address> findByUser(Users user);

}
