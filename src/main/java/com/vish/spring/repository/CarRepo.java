package com.vish.spring.repository;

import com.vish.spring.impl.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepo extends CrudRepository<Car, String> {

}
