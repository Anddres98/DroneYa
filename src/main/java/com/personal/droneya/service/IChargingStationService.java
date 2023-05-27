package com.personal.droneya.service;

import com.personal.droneya.model.entity.ChargingStation;
import org.springframework.stereotype.Service;


public interface IChargingStationService {
    public ChargingStation createUser(ChargingStation user);
    public ChargingStation readUser(Integer id);
    public ChargingStation updateUser(ChargingStation user, Integer id);
    public ChargingStation deleteUser(Integer id);
}
