package com.personal.droneya.service.impl;

import com.personal.droneya.model.entity.ChargingStation;
import com.personal.droneya.model.entity.Drone;
import com.personal.droneya.model.entity.dto.chargin.DroneDtoC;
import com.personal.droneya.model.entity.dto.chargin.StationDtoC;
import com.personal.droneya.model.entity.dto.drones.DroneDtoD;
import com.personal.droneya.repository.ICharginStationRepository;
import com.personal.droneya.repository.IDroneRepository;
import com.personal.droneya.service.IChargingStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChargingStationServiceImpl implements IChargingStationService {

    @Autowired
    private ICharginStationRepository chargingStationRepository;

    @Autowired
    private IDroneRepository droneRepository;

    @Override
    public StationDtoC createStation(ChargingStation chargingStation) {
        chargingStationRepository.save(chargingStation);
        return StationDtoC.builder()
                .id(chargingStation.getId())
                .name(chargingStation.getName())
                .description(chargingStation.getDescription())
                .capacity(chargingStation.getCapacity())
                .latitude(chargingStation.getLatitude())
                .longitude(chargingStation.getLongitude())
                .build();
    }

    @Override
    public StationDtoC readStation(Integer id) {
        Optional<ChargingStation> charginStationDB = chargingStationRepository.findById(id);
        ChargingStation station = charginStationDB.get();
        if (charginStationDB.isPresent()){
            return StationDtoC.builder()
                    .id(station.getId())
                    .name(station.getName())
                    .capacity(station.getCapacity())
                    .latitude(station.getLatitude())
                    .longitude(station.getLongitude())
                    .capacity(station.getCapacity())
                    .description(station.getDescription())
                    .drones(station.getDronesC().stream().map(this::droneMapperDroneDto).collect(Collectors.toList()))
                    .build();
        }
        return StationDtoC.builder()
                .name("CharginStation Invalid")
                .build();
    }

    public DroneDtoC droneMapperDroneDto(Drone drone){
        return  DroneDtoC.builder()
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

    @Override
    public StationDtoC updateStation(ChargingStation chargingStation, Integer id) {
        Optional<ChargingStation> chargingStationOP = chargingStationRepository.findById(id);

        if (chargingStationOP.isPresent()){
            ChargingStation charginStationDB = chargingStationOP.get();
            charginStationDB.setCapacity(chargingStation.getCapacity());
            chargingStationRepository.save(charginStationDB);
            return StationDtoC.builder()
                    .id(charginStationDB.getId())
                    .name(charginStationDB.getName())
                    .capacity(charginStationDB.getCapacity())
                    .longitude(charginStationDB.getLongitude())
                    .latitude(charginStationDB.getLatitude())
                    .description(charginStationDB.getDescription())
                    .drones(charginStationDB.getDronesC().stream().map(this::droneMapperDroneDto).collect(Collectors.toList()))
                    .build();
        }
        return StationDtoC.builder()
                .name("charginStation not found")
                .build();
    }

    @Override
    public StationDtoC deleteStation(Integer id) {
        Optional<ChargingStation> chargingStationDL = chargingStationRepository.findById(id);

        if (chargingStationDL.isPresent()){
            chargingStationRepository.deleteById(id);
            ChargingStation station = chargingStationDL.get();
            return StationDtoC.builder()
                    .id(station.getId())
                    .name(station.getName())
                    .capacity(station.getCapacity())
                    //.drones(station.getDronesC().stream().map(this::droneMapperDroneDto).collect(Collectors.toList()))
                    .description(station.getDescription())
                    .latitude(station.getLatitude())
                    .longitude(station.getLongitude())
                    .build();
        }
        return StationDtoC.builder()
                .name("charginStation not found")
                .build();
    }

    @Override
    public StationDtoC addDrones(ChargingStation station, Integer idDrone) {
        Optional<ChargingStation> stationOP = chargingStationRepository.findById(station.getId());
        Optional<Drone> droneOP = droneRepository.findById(idDrone);

        if (stationOP.isEmpty() || droneOP.isEmpty()){
            return null;
        }
        Drone droneDB = droneOP.get();
        ChargingStation stationsDB = stationOP.get();

        if ( droneDB.getStation() != null){
            return null;
        }

        List<Drone> listDrones =  stationsDB.getDronesC();
        listDrones.add(droneDB);
        stationsDB.setDronesC(listDrones);
        droneDB.setStation(stationsDB);
        chargingStationRepository.save(stationsDB);
        droneRepository.save(droneDB);

        return StationDtoC.builder()
                .id(stationsDB.getId())
                .name(stationsDB.getName())
                .longitude(stationsDB.getLongitude())
                .latitude(stationsDB.getLatitude())
                .description(stationsDB.getDescription())
                .capacity(stationsDB.getCapacity())
                .drones(stationsDB.getDronesC().stream().map(this::droneMapperDroneDto).collect(Collectors.toList()))
                .build();


    }


}
