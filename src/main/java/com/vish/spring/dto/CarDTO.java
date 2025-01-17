package com.vish.spring.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vish.spring.impl.Car;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO implements Serializable {

    String id;
    String model;
    String name;
    String color;
    String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public CarDTO() {
    }

    public CarDTO(Car car) {
        this.color = car.getColor();
        this.name = car.getVehicleName();
        if (car.getUserData() != null) {
            this.userName = car.getUserData().getName();
        }
    }

}
