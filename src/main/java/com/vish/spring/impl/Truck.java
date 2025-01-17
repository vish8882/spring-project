package com.vish.spring.impl;

import com.vish.spring.interfaces.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class Truck implements Vehicle {

  private String vehiclename;
  @Override
  public String getVehicleName() {
    return "truck";
  }

  @Override
  public void setVehicleName(String vehicleName) {
    this.vehiclename = vehicleName;
  }
}
