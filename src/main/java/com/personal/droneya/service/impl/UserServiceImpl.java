package com.personal.droneya.service.impl;

import com.personal.droneya.model.entity.Drone;
import com.personal.droneya.model.entity.User;
import com.personal.droneya.model.entity.dto.user.DroneDtoU;
import com.personal.droneya.model.entity.dto.user.UserDtoU;
import com.personal.droneya.repository.IDroneRepository;
import com.personal.droneya.repository.IUserRepository;
import com.personal.droneya.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IDroneRepository droneRepository;

    @Override
    public UserDtoU createUser(User user) {
        User userSave = userRepository.save(user);

        return UserDtoU.builder()
                .id(userSave.getId())
                .name(userSave.getName())
                .lastName(userSave.getLastName())
                .email(userSave.getEmail())
                .build();

    }

    @Override
    public UserDtoU readUser(Integer id) {
        Optional<User> userDB = userRepository.findById(id);

        if (userDB.isPresent()){
           User user = userDB.get();
            return UserDtoU.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .drones(user.getDrones().stream().map(this::droneMapperDroneDto).collect(Collectors.toList()))
                    .build();
        }

        return UserDtoU.builder()
                .id(911)
                .name("Invalid User")
                .build();
    }

    public DroneDtoU droneMapperDroneDto(Drone drone){
        return DroneDtoU.builder()
                .id(drone.getId())
                .name(drone.getName())
                .description(drone.getDescription())
                .latitude(drone.getLatitude())
                .longitude(drone.getLongitude())
                .type(drone.getType())
                .status(drone.getStatus())
                //.userDto(userMapperUserDto(drone.getUser()))
                .build();
    }

    public UserDtoU userMapperUserDto(User user){
        return UserDtoU.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                //.dronesDto(user.getDrones().stream().map(this::droneMapperDroneDto).collect(Collectors.toList()))
                .build();
    }

    @Override
    public UserDtoU updateUser(User user, Integer id) {
        Optional<User> userOP = userRepository.findById(id);

        if(userOP.isPresent()){
            User userDB = userOP.get();
            userDB.setEmail(user.getEmail());
            userRepository.save(userDB);

            UserDtoU userDto = new UserDtoU().builder()
                    .id(user.getId())
                    .name(user.getName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .build();
            return userDto;
        }
        return UserDtoU.builder()
                .name("User not found")
                .build();
    }

    @Override
    public UserDtoU deleteUser(Integer id) {
        Optional<User> userDL = userRepository.findById(id);
        if(userDL.isPresent()){
            userRepository.deleteById(id);
            UserDtoU userDto = new UserDtoU();
            userDto = UserDtoU.builder()
                    .id(userDto.getId())
                    .name(userDto.getName())
                    .lastName(userDto.getLastName())
                    .email(userDto.getEmail())
                    .drones(userDto.getDrones())
                    .build();
            return userDto;
        }
        return UserDtoU.builder()
                .name("User not Found")
                .build();
    }

    @Override
    public UserDtoU addDrone(User user, Integer idDrone){
        Optional<Drone> droneOP = droneRepository.findById(idDrone);
        Optional<User> userOP = userRepository.findById(user.getId());

        if (droneOP.isEmpty() || userOP.isEmpty()){
            return null;
        }
        User userDB = userOP.get();
        Drone droneDB = droneOP.get();

        if (droneDB.getUser() != null){
            return null;
        }
        /*userDB.getDrones().forEach(drone-> {
            drone.setUser(user);
            }
        );*/
        List<Drone> listDron = userDB.getDrones();
        listDron.add(droneDB);
        droneDB.setUser(userDB);
        userDB.setDrones(listDron);
        droneRepository.save(droneDB);// user.getDrones().add(drone);
        userRepository.save(userDB);


        return UserDtoU.builder()
                .id(userDB.getId())
                .name(userDB.getName())
                .lastName(userDB.getLastName())
                .email(userDB.getEmail())
                .drones(userDB.getDrones().stream().map(this::droneMapperDroneDto).collect(Collectors.toList()))
                .build();


    }

    @GetMapping
    public ResponseEntity<Page<User>> listUsers(Pageable pageable){
        return ResponseEntity.ok(userRepository.findAll(pageable));
    }
}
