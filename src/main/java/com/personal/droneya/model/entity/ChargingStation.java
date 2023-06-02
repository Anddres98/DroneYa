package com.personal.droneya.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ChargingStation {

    @Id
    private Integer id;
    private String name;
    private String description;
    private Double longitude;
    private Double latitude;
    private Integer capacity;

    /*
    private List<Drone> drones;
*/
}

