package com.springcore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springcore.model.Carts;
import com.springcore.model.Users;


@Repository
public interface CartRepository extends JpaRepository<Carts, Integer> {
    List<Carts> findByUser(Users user);
    List<Carts> findByUserAndIsActive(Users user, boolean isActive);

//	List<Cart> findByUser(Users users);
}
