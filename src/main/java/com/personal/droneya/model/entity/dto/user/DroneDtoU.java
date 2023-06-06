package com.personal.droneya.model.entity.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DroneDtoU {

    private Integer id;
    private String name;
    private String description;
    private String status;
    private Double longitude;
    private Double latitude;
    private String type;
    //private UserDto user;
}
