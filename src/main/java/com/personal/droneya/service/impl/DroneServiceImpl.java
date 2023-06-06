package com.personal.droneya.service.impl;

import com.personal.droneya.model.entity.ChargingStation;
import com.personal.droneya.model.entity.Drone;
import com.personal.droneya.model.entity.User;
import com.personal.droneya.model.entity.dto.drones.DroneDtoD;
import com.personal.droneya.model.entity.dto.drones.StationDtoD;
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
    public DroneDtoD createDrone(Drone drone) {
        droneRepository.save(drone);
        return DroneDtoD.builder()
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
                    .station(StationMappStationDtoD(drone.getStation()))
                    .build();

        }
        return DroneDtoD.builder()
                .name("Invalid Drone")
                .build();
    }

    public StationDtoD StationMappStationDtoD(ChargingStation station){
        if (station == null){
            return null;
        }
        return StationDtoD.builder()
                .id(station.getId())
                .capacity(station.getCapacity())
                .name(station.getName())
                .description(station.getDescription())
                .latitude(station.getLatitude())
                .longitude(station.getLongitude())
                .capacity(station.getCapacity())
                .build();
    }
    @Override
    public DroneDtoD updateDrone(Drone drone, Integer id) {
        Optional<Drone> droneOP = droneRepository.findById(id);
        if (droneOP.isPresent()){
            Drone droneDB = droneOP.get();
            droneDB.setStatus(drone.getStatus());
            droneRepository.save(droneDB);

            return DroneDtoD.builder()
                    .id(droneDB.getId())
                    .name(droneDB.getName())
                    .description(droneDB.getDescription())
                    .status(droneDB.getStatus())
                    .latitude(droneDB.getLatitude())
                    .longitude(droneDB.getLongitude())
                    .build();
        }
        return DroneDtoD.builder()
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
                    //.user(userMapperUserDto(droneDl.get().getUser()))
                    .build();
        }
        return DroneDtoD.builder()
                .name("Drone not found")
                .build();
    }

    public DroneDtoD droneMapperDroneDto(Drone drone){
        if (drone == null){
            return null;
        }
        return DroneDtoD.builder()
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
        if (user == null){
            return null;
        }

        return UserDtoD.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                //.dronesDto(user.getDrones().stream().map(this::droneMapperDroneDto).collect(Collectors.toList()))
                .build();
    }


}
