package com.personal.droneya.controller;

import com.personal.droneya.model.entity.Drone;
import com.personal.droneya.model.entity.dto.chargin.StationDtoC;
import com.personal.droneya.model.entity.dto.drones.DroneDtoD;
import com.personal.droneya.model.entity.dto.drones.StationDtoD;
import com.personal.droneya.model.entity.dto.user.DroneDtoU;
import com.personal.droneya.repository.IUserRepository;
import com.personal.droneya.service.IDroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/drones")
public class DroneController {

    @Autowired
    private IDroneService droneService;

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/save")
    private ResponseEntity<DroneDtoD> createDrone(@RequestBody Drone drone){
        return ResponseEntity.ok(droneService.createDrone(drone));
    }

    @GetMapping("/{id}")
    private ResponseEntity<DroneDtoD> getDrone(@PathVariable Integer id){
        return ResponseEntity.ok(droneService.readDrone(id));
    }

    @PutMapping
    private ResponseEntity<DroneDtoD> updateDrone(@RequestBody Drone drone, @RequestParam Integer id){
        return ResponseEntity.ok(droneService.updateDrone(drone, id));
    }

    @DeleteMapping
    private ResponseEntity<DroneDtoD> deletDrone(@RequestParam Integer id){
        return ResponseEntity.ok(droneService.deleteDrone(id));
    }


}
