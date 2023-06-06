package com.springcore.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcore.model.Carts;
import com.springcore.model.Product;
import com.springcore.model.Users;
import com.springcore.repository.CartRepository;
import com.springcore.repository.ProductRepository;
import com.springcore.repository.UserRepository;
import com.springcore.service.CartService;

import utils.CartBody;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserRepository userRepository;
	private CartRepository cartRepository;

	@Autowired
	private CartServiceImpl(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	@Override
	public Carts newCart(CartBody cartBody) {
		Users user = this.userRepository.findById(cartBody.getUserId()).orElseThrow();
		Product product = this.productRepository.findById(cartBody.getProdId()).orElseThrow();

		Carts cart = new Carts();
		cart.setUser(user);
		cart.setProduct(product);
		cart.setActive(true);
		cart.setQuantity(cartBody.getQuantity());

		Carts newCart = this.cartRepository.save(cart);
		return newCart;
	}

	@Override
	public List<Carts> activeCart(Integer userId) {
		Users user = this.userRepository.findById(userId).orElseThrow();

		List<Carts> cart = this.cartRepository.findByUserAndIsActive(user,true);
		return cart;

	}

	@Override
	public Carts updateCart(Integer cartId, Integer quantity) {

		Carts cart = this.cartRepository.findById(cartId).orElseThrow();
		cart.setQuantity(quantity);

		Carts cartQuantity = this.cartRepository.save(cart);
		return cartQuantity;

	}

	@Override
	public Carts inactiveCart(Integer cartId) {
		Carts cart = this.cartRepository.findById(cartId).orElseThrow();
		cart.setActive(false);

		Carts cartState = this.cartRepository.save(cart);
		return cartState;

	}

}
