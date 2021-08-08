package com.ss.springsecuritydemo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
@MapperScan("com.ss.springsecuritydemo1.mapper")
public class SpringSecurityDemo1Application {

  public static void main(String[] args) {
    SpringApplication.run(SpringSecurityDemo1Application.class, args);
  }
}
