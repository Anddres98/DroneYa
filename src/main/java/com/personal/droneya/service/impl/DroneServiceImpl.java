package com.personal.droneya.service.impl;

import com.personal.droneya.model.entity.Drone;
import com.personal.droneya.model.entity.User;
import com.personal.droneya.repository.IDroneRepository;
import com.personal.droneya.service.IDroneService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class DroneServiceImpl implements IDroneService {

    @Autowired
    private IDroneRepository droneRepository;

    @Override
    public Drone createDrone(Drone drone) {
        return droneRepository.save(drone);
    }

    @Override
    public Drone readDrone(Integer id) {
        Optional<Drone> droneDB = droneRepository.findById(id);
        if (droneDB.isPresent()){
            return droneDB.get();
        }
        return Drone.builder()
                .name("Invalid Drone")
                .build();
    }

    @Override
    public Drone updateDrone(Drone drone, Integer id) {
        Optional<Drone> droneOP = droneRepository.findById(id);
        if (droneOP.isPresent()){
            Drone droneDB = droneOP.get();
            droneDB.setStatus(drone.getStatus());
            return droneRepository.save(droneDB);
        }
        return Drone.builder()
                .name("Drone not found")
                .build();
    }

    @Override
    public Drone deleteDrone(Integer id) {
        Optional<Drone> droneDl = droneRepository.findById(id);
        if (droneDl.isPresent()){
            droneRepository.deleteById(id);
            return droneDl.get();
        }
        return Drone.builder()
                .name("Drone not found")
                .build();
    }




}
