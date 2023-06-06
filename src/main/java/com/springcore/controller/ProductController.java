package com.springcore.controller;

import com.springcore.model.Product;
import com.springcore.model.Users;
import com.springcore.service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/product")
public class ProductController {


    @Autowired
    private ProdService prodService;


    @PostMapping("/")
    @CrossOrigin
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product newProduct = this.prodService.createProduct(product);
        return new ResponseEntity<>(newProduct , HttpStatus.CREATED);
    }


    @PutMapping("/{prodId}/quantity")
    @CrossOrigin
    public ResponseEntity<Product> updateProductQuantity(@PathVariable Integer prodId, @RequestBody Integer prodQuantity) {
        Product updatedProduct = prodService.updateProdQuantity(prodQuantity, prodId);
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/products")
    @CrossOrigin
    public ResponseEntity<List<Product>> getAllProducts() {
            List<Product> products = prodService.getAllProducts();
            return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{prodId}")
    @CrossOrigin
    public ResponseEntity<String> deleteItem(@PathVariable Integer prodId){
        this.prodService.deleteProdById(prodId);
        return ResponseEntity.ok("success");
    }


    @GetMapping("/{prodId}")
    @CrossOrigin
    public Product getProductById(@PathVariable("prodId") Integer prodId) {
        return prodService.getProdById(prodId);
    }
    @GetMapping("/users/{userId}")
    public List<Product> getAllProductsByUser(@PathVariable Integer userId) {
        Users user = new Users();
        return prodService.getAllProductByUser(user);
    }

}
