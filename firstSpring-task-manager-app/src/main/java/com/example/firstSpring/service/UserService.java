package com.example.firstSpring.service;

import com.example.firstSpring.entity.UserEntity;
import com.example.firstSpring.exceptions.UserAlreadyExits;
import com.example.firstSpring.exceptions.UserNotFoundException;
import com.example.firstSpring.models.UserModel;
import com.example.firstSpring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
    @Autowired
    private UserRepo _userRepo;

    public UserEntity registerNewUser(UserEntity user) throws UserAlreadyExits {
        try {
            boolean userisFind = _userRepo.findByUsername(user.getUsername()) != null;

            if (!userisFind) {
               return _userRepo.save(user);
            }
            throw new UserAlreadyExits("user " + user.getUsername() + " already exits!");
        }

        catch (Exception e){
            throw  e;
        }
    }

    public UserModel getOne(Long id) throws UserNotFoundException {
        UserEntity user = _userRepo.findById(id).get();

        if (user == null) {
            throw new UserNotFoundException("user not found");
        }

        return  UserModel.toModel(user);
    }
}
