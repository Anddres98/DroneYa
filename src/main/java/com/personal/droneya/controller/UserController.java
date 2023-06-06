package com.personal.droneya.controller;

import com.personal.droneya.model.entity.User;
import com.personal.droneya.model.entity.dto.user.UserDtoU;
import com.personal.droneya.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @PostMapping("/save")
    public ResponseEntity<UserDtoU> createUser(@RequestBody User user){

        return ResponseEntity.ok(userService.createUser(user));
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDtoU> getUser(@PathVariable Integer id){
        return ResponseEntity.ok(userService.readUser(id));
    }

    @PutMapping
    public ResponseEntity<UserDtoU> updateUser(@RequestBody User user, @RequestParam Integer id){
        return ResponseEntity.ok(userService.updateUser(user, id));
    }

    @DeleteMapping
    public ResponseEntity<UserDtoU> deleteUser(@RequestParam Integer id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @PutMapping("/addDrone")
    public ResponseEntity<UserDtoU> addDrone(@RequestBody User user, @RequestParam Integer id){
        return ResponseEntity.ok(userService.addDrone(user, id));
    }

   /*@GetMapping
    public ResponseEntity<Page<User>> listUsers(Pageable pageable){
        return ResponseEntity.ok(userRepository.findAll(pageable));
    }*/

    @PutMapping("/removeDrone")
    public ResponseEntity<UserDtoU> removeDrone(@RequestBody User user, @RequestParam Integer id){
        return ResponseEntity.ok(userService.removeDrone(user, id));
    }


}
