package com.personal.droneya.service;

import com.personal.droneya.model.entity.ChargingStation;
import org.springframework.stereotype.Service;


public interface IChargingStationService {
    public ChargingStation createStation(ChargingStation chargingStation);
    public ChargingStation readStation(Integer id);
    public ChargingStation updateStation(ChargingStation chargingStation,
                                         Integer id);
    public ChargingStation deleteStation(Integer id);
}
