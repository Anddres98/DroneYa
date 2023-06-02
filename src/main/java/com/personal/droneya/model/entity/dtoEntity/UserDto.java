package com.personal.droneya.model.entity.dtoEntity;

import com.personal.droneya.model.entity.Drone;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private List<Drone> drones = new ArrayList<>();
}
