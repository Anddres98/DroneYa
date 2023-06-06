package com.personal.droneya.service;

import com.personal.droneya.model.entity.ChargingStation;
import com.personal.droneya.model.entity.Drone;
import com.personal.droneya.model.entity.dto.chargin.StationDtoC;
import org.springframework.stereotype.Service;


public interface IChargingStationService {
    public StationDtoC createStation(ChargingStation chargingStation);
    public StationDtoC readStation(Integer id);
    public StationDtoC updateStation(ChargingStation chargingStation,
                                         Integer id);
    public StationDtoC deleteStation(Integer id);

    public StationDtoC addDrones(ChargingStation station, Integer idDrone );
}
