package com.springcore.repository;

import com.springcore.model.Orders;
import com.springcore.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    @Query("SELECT o FROM Orders o WHERE o.isActive = true AND o.delivery = false AND o.users = :user")
    List<Orders> findActiveNotDeliveredOrdersByUser(Users user);

    @Query("SELECT o FROM Orders o WHERE o.isActive = true AND o.delivery = true AND o.users = :user")
    List<Orders> findActiveDeliveredOrdersByUser(Users user);
    @Query("SELECT o FROM Orders o WHERE o.isActive = true")
    List<Orders> findActiveOrders();
}
