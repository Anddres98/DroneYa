package com.personal.droneya.service;

import com.personal.droneya.model.entity.Drone;
import com.personal.droneya.model.entity.User;
import org.springframework.stereotype.Service;


public interface IDroneService {
    Drone createDrone(Drone drone);
    Drone readDrone(Integer id);
    Drone updateDrone(Drone drone, Integer id);
    Drone deleteDrone(Integer id);



}
