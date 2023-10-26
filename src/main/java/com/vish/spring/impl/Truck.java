package com.vish.spring.impl;

import com.vish.spring.interfaces.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class Truck implements Vehicle {

  @Override
  public String getVehicleName() {
    return "truck";
  }
}
