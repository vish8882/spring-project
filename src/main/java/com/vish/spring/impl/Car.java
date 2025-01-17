package com.vish.spring.impl;

import com.vish.spring.entity.UserData;
import com.vish.spring.interfaces.Vehicle;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component("car")
@Primary
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.DEFAULT)
@Entity
@Table
public class Car implements Vehicle {

  @Id
  @GeneratedValue
  private int id;
  @Column
  private String color;
  @Column
  private String vehicleName;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "userdata_id")
  private UserData userData;

  public int getId() {
    return id;
  }

  public void setId(int id) {
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

  public UserData getUserData() {
    return userData;
  }

  public void setUserData(UserData userData) {
    this.userData = userData;
  }
}
