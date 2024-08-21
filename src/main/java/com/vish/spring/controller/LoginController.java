package com.vish.spring.controller;

import com.vish.spring.entity.UserData;
import com.vish.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {

  @Autowired
  UserService userService;

  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }

  @GetMapping("register")
  public String registerPage(Model model) {
    UserData user = new UserData();
    model.addAttribute("user", user);
    return "register";
  }

  @PostMapping("/register/user")
  public String registerUser(@RequestBody UserData user, Model model) {
    UserData existing = userService.getUser(user.getEmail());
    if(existing != null) {
      return "register";
    }
    userService.saveUser(user);
    return "redirect:/login";
  }


}
