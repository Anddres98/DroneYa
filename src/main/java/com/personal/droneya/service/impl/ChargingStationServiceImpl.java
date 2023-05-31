package com.personal.droneya.service.impl;

import com.personal.droneya.model.entity.ChargingStation;
import com.personal.droneya.repository.ICharginStationRepository;
import com.personal.droneya.service.IChargingStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChargingStationServiceImpl implements IChargingStationService {

    @Autowired
    private ICharginStationRepository chargingStationRepository;

    @Override
    public ChargingStation createStation(ChargingStation chargingStation) {
        return chargingStationRepository.save(chargingStation);
    }

    @Override
    public ChargingStation readStation(Integer id) {
        Optional<ChargingStation> charginStationDB = chargingStationRepository.findById(id);
        if (charginStationDB.isPresent()){
            return charginStationDB.get();
        }
        return ChargingStation.builder()
                .name("CharginStation Invalid")
                .build();
    }

    @Override
    public ChargingStation updateStation(ChargingStation chargingStation, Integer id) {
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
    public ChargingStation deleteStation(Integer id) {
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
