package com.personal.droneya.model.entity.dto.drones;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DroneDtoD {

    private Integer id;
    private String name;
    private String description;
    private String status;
    private Double longitude;
    private Double latitude;
    private String type;
    private UserDtoD user;
}
