package com.personal.droneya.service.impl;

import com.personal.droneya.model.entity.Drone;
import com.personal.droneya.model.entity.User;
import com.personal.droneya.model.entity.dto.drones.DroneDtoD;
import com.personal.droneya.model.entity.dto.drones.UserDtoD;
import com.personal.droneya.model.entity.dto.user.DroneDtoU;
import com.personal.droneya.model.entity.dto.user.UserDtoU;
import com.personal.droneya.repository.IDroneRepository;
import com.personal.droneya.service.IDroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DroneServiceImpl implements IDroneService {

    @Autowired
    private IDroneRepository droneRepository;

    @Override
    public DroneDtoU createDrone(Drone drone) {
        droneRepository.save(drone);
        return DroneDtoU.builder()
                .id(drone.getId())
                .name(drone.getName())
                .type(drone.getType())
                .longitude(drone.getLongitude())
                .description(drone.getDescription())
                .latitude(drone.getLatitude())
                .status(drone.getStatus())
                .build();

    }

    @Override
    public DroneDtoD readDrone(Integer id) {
        Optional<Drone> droneDB = droneRepository.findById(id);
        if (droneDB.isPresent()){
            Drone drone = droneDB.get();
            return DroneDtoD.builder()
                    .id(drone.getId())
                    .name(drone.getName())
                    .status(drone.getStatus())
                    .description(drone.getDescription())
                    .user(userMapperUserDto(drone.getUser()))
                    .latitude(drone.getLatitude())
                    .longitude(drone.getLongitude())
                    .type(drone.getType())
                    .build();

        }
        return DroneDtoD.builder()
                .name("Invalid Drone")
                .build();
    }

    @Override
    public DroneDtoU updateDrone(Drone drone, Integer id) {
        Optional<Drone> droneOP = droneRepository.findById(id);
        if (droneOP.isPresent()){
            Drone droneDB = droneOP.get();
            droneDB.setStatus(drone.getStatus());
            droneRepository.save(droneDB);

            DroneDtoU droneDto = new DroneDtoU();

            return DroneDtoU.builder()
                    .id(id)
                    .name(drone.getName())
                    .description(drone.getDescription())
                    .status(droneDB.getStatus())
                    .build();
        }
        return DroneDtoU.builder()
                .name("Drone not found")
                .build();
    }

    @Override
    public DroneDtoD deleteDrone(Integer id) {
        Optional<Drone> droneDl = droneRepository.findById(id);
        if (droneDl.isPresent()){
            droneRepository.deleteById(id);

            return DroneDtoD.builder()
                    .id(droneDl.get().getId())
                    .name(droneDl.get().getName())
                    .status(droneDl.get().getStatus())
                    .user(userMapperUserDto(droneDl.get().getUser()))
                    .build();
        }
        return DroneDtoD.builder()
                .name("Drone not found")
                .build();
    }

    public DroneDtoU droneMapperDroneDto(Drone drone){
        return DroneDtoU.builder()
                .id(drone.getId())
                .name(drone.getName())
                .description(drone.getDescription())
                .latitude(drone.getLatitude())
                .longitude(drone.getLongitude())
                .type(drone.getType())
                .status(drone.getStatus())
                //.userDto(userMapperUserDto(drone.getUser()))
                .build();
    }

    public UserDtoD userMapperUserDto(User user){
        return UserDtoD.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                //.dronesDto(user.getDrones().stream().map(this::droneMapperDroneDto).collect(Collectors.toList()))
                .build();
    }


}
