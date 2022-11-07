package com.eden.minicafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MinicafeApplication {

  public static void main(String[] args) {
    SpringApplication.run(MinicafeApplication.class, args);
  }

}
