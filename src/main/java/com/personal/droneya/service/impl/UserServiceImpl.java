package com.personal.droneya.service.impl;

import com.personal.droneya.model.entity.User;
import com.personal.droneya.repository.IUserRepository;
import com.personal.droneya.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User readUser(Integer id) {
        Optional<User> userDB = userRepository.findById(id);
        System.out.println("Aqui get "+userDB);
        if (userDB.isPresent()){
            return userDB.get();
        }
        return User.builder()
                .id(911)
                .name("Invalid User")
                .build();
    }

    @Override
    public User updateUser(User user, Integer id) {
        Optional<User> userOP = userRepository.findById(id);
        if(userOP.isPresent()){
            User userDB = userOP.get();
            userDB.setEmail(user.getEmail());
            return userRepository.save(userDB);
        }
        return User.builder()
                .name("User not found")
                .build();
    }

    @Override
    public User deleteUser(Integer id) {
        Optional<User> userDL = userRepository.findById(id);
        if(userDL.isPresent()){
            userRepository.deleteById(id);
            return userDL.get();
        }
        return User.builder()
                .name("User not Found")
                .build();
    }
}
