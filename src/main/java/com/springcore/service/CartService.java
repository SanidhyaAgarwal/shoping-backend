package com.springcore.service;

import java.util.List;

import com.springcore.model.Carts;

import utils.CartBody;

public interface CartService {

	Carts newCart(CartBody cartBody);

	List<Carts> activeCart(Integer userId);

	Carts updateCart(Integer cartId, Integer quantity);

	Carts inactiveCart(Integer cartId);

}
