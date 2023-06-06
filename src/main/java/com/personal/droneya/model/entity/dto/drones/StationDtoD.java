package com.personal.droneya.model.entity.dto.drones;

import com.personal.droneya.model.entity.Drone;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class StationDtoD {

    private Integer id;
    private String name;
    private String description;
    private Double longitude;
    private Double latitude;
    private Integer capacity;

}
