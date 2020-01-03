package com.eronsdegus.yeye.controller;

import com.eronsdegus.yeye.dto.User;
import com.eronsdegus.yeye.repository.UserRepository;
import com.eronsdegus.yeye.service.SecurityService;
import com.eronsdegus.yeye.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(UserController.class);
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    Collection<User> users() {
        return userRepository.findAll();
    }

    @PostMapping("/registration")
    public String registration(@RequestBody User userForm) {

        try{
            userService.save(userForm);

            securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
            return "success";
        }catch (Exception e){
            return "failed";
        }
    }

}
