package com.springcore.controller;


import com.springcore.model.Carts;

import com.springcore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.CartBody;

import java.util.List;


@RestController
@RequestMapping("api/carts")
public class CartController {


    @Autowired
    private CartService cartService;

    @PostMapping("/")
    @CrossOrigin
    public ResponseEntity<Carts> createCarts(@RequestBody CartBody cartBody){

        Carts carts = this.cartService.newCart(cartBody);

        return  new ResponseEntity<>(carts , HttpStatus.CREATED);
    }

    @GetMapping("/active/{userId}")
    @CrossOrigin
    public ResponseEntity<List<Carts>> activeCart(@PathVariable Integer userId) {
        List<Carts> activeCarts = cartService.activeCart(userId);
        return new ResponseEntity<>(activeCarts, HttpStatus.OK);
    }

    @PutMapping("/{cartId}")
    @CrossOrigin
    public ResponseEntity<Carts> updateCart(@PathVariable Integer cartId, @RequestParam Integer quantity) {
        Carts updatedCart = cartService.updateCart(cartId, quantity);
        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
    }
    @PutMapping("/inactive/{cartId}")
    @CrossOrigin
    public ResponseEntity<Carts> inactiveCart(@PathVariable Integer cartId) {
        Carts inactiveCart = cartService.inactiveCart(cartId);
        return new ResponseEntity<>(inactiveCart, HttpStatus.OK);
    }


}
