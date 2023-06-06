package com.personal.droneya.model.entity.dto.chargin;

import com.personal.droneya.model.entity.dto.drones.UserDtoD;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DroneDtoC {

    private Integer id;
    private String name;
    private String description;
    private String status;
    private Double longitude;
    private Double latitude;
    private String type;
    //private UserDtoD user;

}
