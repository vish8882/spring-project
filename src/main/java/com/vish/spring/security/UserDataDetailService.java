package com.vish.spring.security;

import com.vish.spring.entity.UserData;
import com.vish.spring.repository.UserRepo;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDataDetailService implements UserDetailsService {

  @Autowired
  UserRepo userRepo;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserData user = userRepo.findByEmail(username);
    if (user != null) {
      return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
    throw new UsernameNotFoundException("Username not found");
  }
}
