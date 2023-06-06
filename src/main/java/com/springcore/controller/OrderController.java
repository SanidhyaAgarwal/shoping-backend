package com.springcore.controller;


import com.springcore.model.Orders;
import com.springcore.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.OrderBody;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {


    @Autowired
    private OrdersService ordersService;


    @PostMapping("/")
    @CrossOrigin
    public ResponseEntity<Orders> createOrders(@RequestBody OrderBody orderBody){

        Orders orders = this.ordersService.createOrder(orderBody);
        return  new ResponseEntity<>(orders , HttpStatus.CREATED);
    }

    @GetMapping("/undelivered/{userId}")
    @CrossOrigin
    public ResponseEntity<List<Orders>> getActiveUndeliveredOrders(@PathVariable Integer userId) {

        List<Orders> orders=this.ordersService.activeUndelivered(userId);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @GetMapping("/delivered/{userId}")
    @CrossOrigin
    public ResponseEntity<List<Orders>> getActiveDeliveredOrders(@PathVariable Integer userId) {

        List<Orders> orders=this.ordersService.activeDelivered(userId);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @GetMapping("/")
    @CrossOrigin
    public ResponseEntity<List<Orders>> getAllActiveOrders(){
        List<Orders> orders=this.ordersService.getAllActiveOrders();
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @PutMapping("cancel/{orderId}")
    @CrossOrigin
    public ResponseEntity<Orders> cancelOrder(@PathVariable Integer orderId){
        Orders orders=this.ordersService.cancelOrder(orderId);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }
    @PutMapping("delivery/{orderId}")
    @CrossOrigin
    public ResponseEntity<Orders> deliverOrder(@PathVariable Integer orderId){
        Orders orders=this.ordersService.setDeliveryStatus(orderId);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }


}
