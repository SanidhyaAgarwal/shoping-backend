package com.springcore.service.Impl;

import com.springcore.model.Address;
import com.springcore.model.Carts;
import com.springcore.model.Orders;
import com.springcore.model.Users;
import com.springcore.repository.AddressRepository;
import com.springcore.repository.CartRepository;
import com.springcore.repository.OrdersRepository;
import com.springcore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcore.service.OrdersService;
import utils.OrderBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CartRepository cartRepository;
    @Override
    public Orders createOrder(OrderBody orderBody) {
        Users users = this.userRepository.findById(orderBody.getUserId()).orElseThrow();
        Address address = this.addressRepository.findById(orderBody.getAddressId()).orElseThrow();
        long total= 0l;
        List<Carts> newCart = new ArrayList<>();

        System.out.println(orderBody.getCartId());
        for(Integer id:orderBody.getCartId()){
            Carts carts=this.cartRepository.findById(id).orElseThrow();
            total+=(carts.getProduct().getPrice()*carts.getQuantity());
            carts.setActive(false);
            this.cartRepository.save(carts);
            newCart.add(carts);
        }

        System.out.println(newCart);
        Orders orders = new Orders();
        orders.setUsers(users);
//        orders.setAddress(address);
        orders.setCarts(newCart);
        orders.setTotal(total);
        orders.setAddress(address);

        Orders newOrder = this.ordersRepository.save(orders);

        return newOrder;
    }

    @Override
    public List<Orders> activeUndelivered(Integer userId){

        Users users = this.userRepository.findById(userId).orElseThrow();
        List<Orders> orders = this.ordersRepository.findActiveNotDeliveredOrdersByUser(users);
        return orders;

    }

    @Override
    public List<Orders> activeDelivered(Integer userId){

        Users users = this.userRepository.findById(userId).orElseThrow();
        List<Orders> orders = this.ordersRepository.findActiveDeliveredOrdersByUser(users);
        return orders;

    }

    @Override
    public List<Orders> getAllActiveOrders(){
        List<Orders> orders = this.ordersRepository.findActiveOrders();
        return orders;

    }


    @Override
    public Orders cancelOrder(Integer orderId) {
        Orders orders=this.ordersRepository.findById(orderId).orElseThrow();
        orders.setActive(false);
        Orders orders1=this.ordersRepository.save(orders);
        return orders1;
    }

    @Override
    public Orders setDeliveryStatus(Integer orderId) {
        Orders orders=this.ordersRepository.findById(orderId).orElseThrow();
        orders.setDelivery(true);
        Orders orders1=this.ordersRepository.save(orders);
        return orders1;
    }




}
