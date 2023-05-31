package com.personal.droneya.controller;

import com.personal.droneya.model.entity.ChargingStation;
import com.personal.droneya.service.IChargingStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stations")
public class CharginStationController {

    @Autowired
    private IChargingStationService chargingStationService;

    @PostMapping("/save")
    public ResponseEntity<ChargingStation> getStation(@RequestBody ChargingStation station){
        return ResponseEntity.ok(chargingStationService.createStation(station));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChargingStation> getStation(@PathVariable Integer id){
        return ResponseEntity.ok(chargingStationService.readStation(id));
    }

    @PutMapping
    public ResponseEntity<ChargingStation> updateStation(@RequestBody ChargingStation station, @RequestParam Integer id){
        return ResponseEntity.ok(chargingStationService.updateStation(station, id));
    }

    @DeleteMapping
    public ResponseEntity<ChargingStation> deleteStation(@RequestParam Integer id){
        return ResponseEntity.ok(chargingStationService.deleteStation(id));
    }
}
