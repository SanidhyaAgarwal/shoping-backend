package com.springcore.controller;


import com.springcore.model.Users;
import com.springcore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.LoginCredentialsDto;
import utils.userLogin;

@RestController
@RequestMapping("api/user")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/")
    @CrossOrigin
    public ResponseEntity<Users> createUser(@RequestBody Users users){
        Users user = this.userService.createUser(users);
        return new ResponseEntity<>(user , HttpStatus.CREATED);
    }
    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<Users> loginUser(@RequestBody userLogin users){
        Users user = this.userService.userlogin(users);
        return new ResponseEntity<>(user , HttpStatus.CREATED);
    }


    @PutMapping("/{userId}/password")
    @CrossOrigin
    public ResponseEntity<Users> updatePassword(@PathVariable Integer userId, @RequestBody String password) {
        Users updatedUserPassword = userService.updateUserPassword(password, userId);
        return ResponseEntity.ok(updatedUserPassword);
    }


    @GetMapping("/users/{userId}")
    @CrossOrigin
    public Users getUserById(@PathVariable Integer userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/oauth")
    @CrossOrigin
    public ResponseEntity<Users> getUserByEmail(@RequestBody LoginCredentialsDto loginCredentialsDto){
        Users users = this.userService.getUserByEmail(loginCredentialsDto);
        return new ResponseEntity<>(users,HttpStatus.FOUND);
    }


}
