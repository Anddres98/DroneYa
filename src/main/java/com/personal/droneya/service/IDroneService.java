package com.personal.droneya.service;

import com.personal.droneya.model.entity.Drone;
import org.springframework.stereotype.Service;


public interface IDroneService {
    public Drone createUser(Drone drone);
    public Drone readUser(Integer id);
    public Drone updateUser(Drone drone, Integer id);
    public Drone deleteUser(Integer id);

}
