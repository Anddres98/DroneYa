package com.personal.droneya.model.entity.dto.chargin;

import com.personal.droneya.model.entity.Drone;
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
public class StationDtoC {

    private Integer id;
    private String name;
    private String description;
    private Double longitude;
    private Double latitude;
    private Integer capacity;
    private List<DroneDtoC> drones = new ArrayList<>();

}
