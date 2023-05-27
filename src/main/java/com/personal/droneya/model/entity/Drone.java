package com.personal.droneya.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Drone {

    @Id
    private Integer id;
    private String name;
    private String description;
    private String status;
    private Double longitude;
    private Double latitude;
    private String type;

}
