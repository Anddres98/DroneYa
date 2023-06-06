package com.personal.droneya.controller;

import com.personal.droneya.model.entity.ChargingStation;
import com.personal.droneya.model.entity.dto.chargin.StationDtoC;
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
    public ResponseEntity<StationDtoC> getStation(@RequestBody ChargingStation station){
        return ResponseEntity.ok(chargingStationService.createStation(station));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StationDtoC> getStation(@PathVariable Integer id){
        return ResponseEntity.ok(chargingStationService.readStation(id));
    }

    @PutMapping
    public ResponseEntity<StationDtoC> updateStation(@RequestBody ChargingStation station, @RequestParam Integer id){
        return ResponseEntity.ok(chargingStationService.updateStation(station, id));
    }

    @DeleteMapping
    public ResponseEntity<StationDtoC> deleteStation(@RequestParam Integer id){
        return ResponseEntity.ok(chargingStationService.deleteStation(id));
    }

    @PutMapping("/addDrones")
    public ResponseEntity<StationDtoC> addDrone(@RequestBody ChargingStation chargingStation, @RequestParam Integer idDrone){
        return ResponseEntity.ok(chargingStationService.addDrones(chargingStation, idDrone));
    }
}
