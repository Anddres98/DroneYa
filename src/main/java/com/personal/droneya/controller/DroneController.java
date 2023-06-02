package com.personal.droneya.controller;

import com.personal.droneya.model.entity.Drone;
import com.personal.droneya.service.IDroneService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/drones")
public class DroneController {

    @Autowired
    private IDroneService droneService;

    @PostMapping("/save")
    private ResponseEntity<Drone> createDrone(@RequestBody Drone drone){
        return ResponseEntity.ok(droneService.createDrone(drone));
    }

    @GetMapping("/{id}")
    private ResponseEntity<Drone> getDrone(@PathVariable Integer id){
        return ResponseEntity.ok(droneService.readDrone(id));
    }

    @PutMapping
    private ResponseEntity<Drone> updateDrone(@RequestBody Drone drone, @RequestParam Integer id){
        return ResponseEntity.ok(droneService.updateDrone(drone, id));
    }

    @DeleteMapping
    private ResponseEntity<Drone> deletDrone(@RequestParam Integer id){
        return ResponseEntity.ok(droneService.deleteDrone(id));
    }


}
