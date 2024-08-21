package com.vish.spring.controller;

import com.vish.spring.entity.UserData;
import com.vish.spring.impl.Car;
import com.vish.spring.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  CarService carService;
  @PostMapping("/user/car/save")
  public Car registerCarToUser(Car car) {
    return carService.saveCar(car);
  }


}
