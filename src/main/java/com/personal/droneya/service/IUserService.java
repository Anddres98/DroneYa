package com.personal.droneya.service;

import com.personal.droneya.model.entity.User;
import com.personal.droneya.model.entity.dto.user.UserDtoU;

/***
 * Aqui va la logica de la aplicacion
 * va un crud
 * Create
 * Read
 * Update
 * Delete
 */

public interface IUserService {

    UserDtoU createUser(User user);
    UserDtoU readUser(Integer id);
    UserDtoU updateUser(User user, Integer id);
    UserDtoU deleteUser(Integer id);

    UserDtoU addDrone(User user, Integer idDrone);


}
