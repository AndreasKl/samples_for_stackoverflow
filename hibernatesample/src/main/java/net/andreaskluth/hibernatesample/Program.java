package net.andreaskluth.hibernatesample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Program {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(Program.class);
    EmployeeService service = context.getBean(EmployeeService.class);

    service.createOrUpdateEmployee("Andreas", "Kluth");

    context.close();
  }

}
