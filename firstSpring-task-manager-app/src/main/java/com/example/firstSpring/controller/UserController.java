package com.example.firstSpring.controller;

import com.example.firstSpring.entity.UserEntity;
import com.example.firstSpring.exceptions.UserAlreadyExits;
import com.example.firstSpring.exceptions.UserNotFoundException;
import com.example.firstSpring.models.UserModel;
import com.example.firstSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController extends  BaseController {

    @Autowired
    private UserService _userService;

    @PostMapping
    public ResponseEntity registerNewUser(@RequestBody UserEntity user) {
        try {
            _userService.registerNewUser(user);
            return ResponseEntity.ok("user as created");
        }

        catch (UserAlreadyExits e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity getUserOne(@RequestParam Long id) {
        try {
          UserModel user =  _userService.getOne(id);

            return ResponseEntity.ok(user);
        }
        catch (UserNotFoundException e){
            return returnBadRequestWithBody(e);
        }
        catch (Exception e){
            return returnBadRequestWithBody(e);
        }
    }

    public ResponseEntity returnBadRequestWithBody (Exception exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
