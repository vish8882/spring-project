package com.vish.spring.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vish.spring.entity.UserData;
import com.vish.spring.impl.Car;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO implements Serializable {

    String  name;
    String email;
    @JsonProperty("cars")
    List<CarDTO> carDTOList;

    public UserDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CarDTO> getCarDTOList() {
        return carDTOList;
    }

    public void setCarDTOList(List<CarDTO> carDTOList) {
        this.carDTOList = carDTOList;
    }

    public UserDTO(UserData userData) {
        this.name = userData.getName();
        this.email = userData.getEmail();
        if(userData.getCars() != null) {
            carDTOList = new ArrayList<>();
            for (Car car : userData.getCars()) {
                carDTOList.add(new CarDTO(car));
            }
        }
    }

    public UserData mapUser() {
        UserData userData = new UserData();
        userData.setName(this.name);
        userData.setEmail(this.email);

        return userData;
    }

}
