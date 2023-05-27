package com.personal.droneya.service;

import com.personal.droneya.model.entity.User;

import java.util.Optional;

/***
 * Aqui va la logica de la aplicacion
 * va un crud
 * Create
 * Read
 * Update
 * Delete
 */

public interface IUserService {

    public User createUser(User user);
    public User readUser(Integer id);
    public User updateUser(User user, Integer id);
    public User deleteUser(Integer id);


}
