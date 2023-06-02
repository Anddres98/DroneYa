package com.personal.droneya.model.entity;

import com.personal.droneya.service.impl.DroneServiceImpl;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    private Integer id;
    private String name;
    private String lastName;
    private String email;
    @OneToMany
    private List<Drone> drones = new ArrayList<>();


}
