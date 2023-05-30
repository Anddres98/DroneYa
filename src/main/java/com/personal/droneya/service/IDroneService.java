package com.personal.droneya.service;

import com.personal.droneya.model.entity.Drone;
import org.springframework.stereotype.Service;


public interface IDroneService {
    public Drone createDrone(Drone drone);
    public Drone readDrone(Integer id);
    public Drone updateDrone(Drone drone, Integer id);
    public Drone deleteDrone(Integer id);

}
