package com.vish.spring.service;

import com.vish.spring.impl.Car;
import com.vish.spring.repository.CarRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

  @Autowired
  CarRepo carRepo;


  public List<Car> getAllCar() {
    List<Car> vehicleList = new ArrayList<>();
    carRepo.findAll().forEach(vehicleList::add);
    return vehicleList;
  }

  public Car getCar(String id) {
    Optional<Car> car = carRepo.findById(id);
    if (car.isPresent()) {
      return car.get();
    }
    return null;
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

}
