package com.vish.spring.controller;

import com.vish.spring.dto.CarDTO;
import com.vish.spring.impl.Car;
import com.vish.spring.service.CarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

  @GetMapping("/car")
  private List<CarDTO> getAllCar() {
    return carService.getAllCar();
  }

  @GetMapping("/car/{id}")
  private Car getCar(@PathVariable("id") String id) {
    return carService.getCar(id);
  }

  @PostMapping("/car")
  private Car saveCar(@RequestBody Car vehicle) {
    return carService.saveCar(vehicle);
  }

  @DeleteMapping("/car/{id}")
  private void deleteCar(@PathVariable("id") String id) {
    carService.deleteById(id);
  }



  @PostMapping("/car/{id}/user/{userId}")
  private ResponseEntity<CarDTO> associateCar(@PathVariable("id") String carID,
                                              @PathVariable("userId") String userId) {
    try {
      CarDTO carDTO = carService.associateUser(carID, userId);
      return new ResponseEntity<>(carDTO, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
