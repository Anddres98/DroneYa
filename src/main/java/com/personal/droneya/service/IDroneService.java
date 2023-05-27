package com.personal.droneya.service;

import com.personal.droneya.model.entity.Drone;
import org.springframework.stereotype.Service;


public interface IDroneService {
    public Drone createUser(Drone user);
    public Drone readUser(Integer id);
    public Drone updateUser(Drone user, Integer id);
    public Drone deleteUser(Integer id);

}
