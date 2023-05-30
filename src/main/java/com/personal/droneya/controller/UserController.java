package com.personal.droneya.controller;

import com.personal.droneya.model.entity.User;
import com.personal.droneya.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    /***
     *
     * @param user es el cliente que alquila el dron y se encuentra en la DB
     * @return un ResponseEntity(Formato JSon de tipo usuario) coge el usuario con sus atributos y
     * crea un JSON
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id){
        return ResponseEntity.ok(userService.readUser(id));
    }

    @PostMapping
    public ResponseEntity<User> updateUser(@RequestBody User user, Integer id){
        return ResponseEntity.ok(userService.updateUser(user, id));
    }



}
