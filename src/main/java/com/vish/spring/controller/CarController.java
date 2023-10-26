package com.vish.spring.controller;

import com.vish.spring.impl.Car;
import com.vish.spring.service.CarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

  @Autowired
  CarService carService;

  @GetMapping("/vehicle")
  private List<Car> getAllCar() {
    return carService.getAllCar();
  }

  @GetMapping("/vehicle/{id}")
  private Car getCar(@PathVariable("id") String id) {
    return carService.getCar(id);
  }

  @PostMapping("/vehicle")
  private Car saveCar(@RequestBody Car vehicle) {
    return carService.saveCar(vehicle);
  }

  @DeleteMapping("/vehicle/{id}")
  private void deleteCar(@PathVariable("id") String id) {
    carService.deleteById(id);
  }

}
