package com.personal.droneya.service.impl;

import com.personal.droneya.model.entity.ChargingStation;
import com.personal.droneya.repository.ICharginStationRepository;
import com.personal.droneya.service.IChargingStationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ChargingStationServiceImpl implements IChargingStationService {

    @Autowired
    private ICharginStationRepository chargingStationRepository;

    @Override
    public ChargingStation createUser(ChargingStation chargingStation) {
        return chargingStationRepository.save(chargingStation);
    }

    @Override
    public ChargingStation readUser(Integer id) {
        Optional<ChargingStation> charginStationDB = chargingStationRepository.findById(id);
        if (charginStationDB.isPresent()){
            return charginStationDB.get();
        }
        return ChargingStation.builder()
                .name("CharginStation Invalid")
                .build();
    }

    @Override
    public ChargingStation updateUser(ChargingStation chargingStation, Integer id) {
        Optional<ChargingStation> chargingStationOP = chargingStationRepository.findById(id);
        if (chargingStationOP.isPresent()){
            ChargingStation charginStationDB = chargingStationOP.get();
            charginStationDB.setCapacity(chargingStation.getCapacity());
            return chargingStationRepository.save(charginStationDB);
        }
        return ChargingStation.builder()
                .name("charginStation not found")
                .build();
    }

    @Override
    public ChargingStation deleteUser(Integer id) {
        Optional<ChargingStation> chargingStationDL = chargingStationRepository.findById(id);
        if (chargingStationDL.isPresent()){
            chargingStationRepository.deleteById(id);
            return chargingStationDL.get();
        }
        return ChargingStation.builder()
                .name("charginStation not found")
                .build();
    }
}
