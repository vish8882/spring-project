package com.vish.spring.controller;

import com.vish.spring.dto.UserDTO;
import com.vish.spring.entity.UserData;
import com.vish.spring.impl.Car;
import com.vish.spring.service.CarService;
import com.vish.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

  @Autowired
  CarService carService;

  @Autowired
  UserService userService;

  @PostMapping("/user/car/save")
  public Car registerCarToUser(Car car) {
    return carService.saveCar(car);
  }

  @GetMapping("/user")
  public List<UserDTO> getUsers() {
    return userService.getAllUsers();
  }


}
