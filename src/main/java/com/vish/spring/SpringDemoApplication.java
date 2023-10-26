package com.vish.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDemoApplication {

  static Logger LOGGER = LoggerFactory.getLogger(SpringDemoApplication.class);
  public static void main(String[] args) {
    SpringApplication.run(SpringDemoApplication.class, args);
  }
}
