package com.personal.droneya.service;

import com.personal.droneya.model.entity.Drone;
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

    User createUser(User user);
    User readUser(Integer id);
    User updateUser(User user, Integer id);
    User deleteUser(Integer id);

    User addDrone(User user);


}
