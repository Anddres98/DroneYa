package com.personal.droneya.controller;

import com.personal.droneya.model.entity.ChargingStation;
import com.personal.droneya.service.IChargingStationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Stations")
public class CharginStationController {

    private IChargingStationService chargingStationService;

    @PostMapping
    public ResponseEntity<ChargingStation> getStation(@RequestBody ChargingStation station){
        return ResponseEntity.ok(chargingStationService.createStation(station));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChargingStation> getStation(@PathVariable Integer id){
        return ResponseEntity.ok(chargingStationService.readStation(id));
    }

    @PostMapping
    public ResponseEntity<ChargingStation> updateStation(@RequestBody ChargingStation station, Integer id){
        return ResponseEntity.ok(chargingStationService.updateStation(station, id));
    }
}
