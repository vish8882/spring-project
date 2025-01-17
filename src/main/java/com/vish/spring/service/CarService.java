package com.vish.spring.service;

import com.vish.spring.dto.CarDTO;
import com.vish.spring.entity.UserData;
import com.vish.spring.impl.Car;
import com.vish.spring.repository.CarRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.vish.spring.repository.UserRepo;
import com.vish.spring.service.exception.NoCarFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CarService {

  @Autowired
  CarRepo carRepo;

  @Autowired
  UserRepo userRepo;


  public List<CarDTO> getAllCar() {
    List<CarDTO> vehicleList = new ArrayList<>();
    carRepo.findAll().forEach(c -> vehicleList.add(new CarDTO(c)));
    return vehicleList;
  }

  public Car getCar(String id) {
    Optional<Car> car = carRepo.findById(id);
      return car.orElse(null);
  }

  public Car saveCar(Car car) {
    return carRepo.save(car);
  }

  public void deleteById(String id) {
    carRepo.deleteById(id);
  }

  public void delete(Car car) {
    carRepo.delete(car);
  }

  public CarDTO associateUser(String carId, String userId) throws Exception {
    UserData userData = userRepo.findByEmail(userId);
    Car car = carRepo.findById(carId)
            .orElseThrow(() -> new NoCarFoundException("Car did not exist with the name"));
    car.setUserData(userData);
    carRepo.save(car);
    return new CarDTO(car);
  }

}
