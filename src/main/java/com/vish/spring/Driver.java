package com.vish.spring;

import com.vish.spring.interfaces.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Driver {


  @Qualifier("car")
  private Vehicle vehicle;

  @Autowired()
  public void setVehicle(Vehicle vehicle) {
    System.out.printf("hello how are");
    this.vehicle = vehicle;
  }

  public Vehicle getVehicle() {
    return this.vehicle;
  }

  public String drive() {
    return "I drive "+ vehicle.getVehicleName();
  }

}
