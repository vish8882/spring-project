package com.vish.spring.service;

import com.vish.spring.entity.UserData;
import com.vish.spring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserService {

  @Autowired
  PasswordEncoder bCrypt;
  @Autowired
  UserRepo userRepo;
  public void saveUser(UserData user) {
    user.setPassword(bCrypt.encode(user.getPassword()));
    userRepo.save(user);
  }

  public UserData getUser(String email) {
    return userRepo.findByEmail(email).orElse(null);
  }

}
