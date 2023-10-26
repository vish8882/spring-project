package com.vish.spring.impl;

import com.vish.spring.interfaces.Vehicle;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.DEFAULT)
@Entity
@Table
public class Car implements Vehicle {

  @Id
  private String id;
  @Column
  private String color;
  @Column
  private String vehicleName;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setVehicleName(String vehicleName) {
    this.vehicleName = vehicleName;
  }
  public String getVehicleName() {
    return this.vehicleName;
  }
}
