package com.springcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcore.model.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer>  {

    Users findUsersByEmailAndPassword(String email, String password);

}
