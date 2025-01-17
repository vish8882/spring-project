package com.vish.spring;

import com.vish.spring.impl.Car;
import com.vish.spring.interfaces.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDemoApplication {

  static Logger LOGGER = LoggerFactory.getLogger(SpringDemoApplication.class);

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(SpringDemoApplication.class, args);
    Vehicle vehicle = context.getBean(Car.class);
    System.out.println(vehicle.getVehicleName());
    vehicle.setVehicleName("different");
    LOGGER.debug("Started application");
    Car car1 = context.getBean(Car.class);
    System.out.println(car1.getVehicleName());
  }
}
