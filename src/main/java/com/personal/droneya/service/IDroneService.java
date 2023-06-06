package com.personal.droneya.service;

import com.personal.droneya.model.entity.Drone;
import com.personal.droneya.model.entity.dto.drones.DroneDtoD;
import com.personal.droneya.model.entity.dto.user.DroneDtoU;


public interface IDroneService {
    DroneDtoU createDrone(Drone drone);
    DroneDtoD readDrone(Integer id);
    DroneDtoU updateDrone(Drone drone, Integer id);
    DroneDtoD deleteDrone(Integer id);



}
