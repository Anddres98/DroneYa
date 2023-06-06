package com.personal.droneya.model.entity.dto.user;

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
public class UserDtoU {

    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private List<DroneDtoU> drones = new ArrayList<>();
}
