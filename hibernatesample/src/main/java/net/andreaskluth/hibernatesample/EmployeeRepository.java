package net.andreaskluth.hibernatesample;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
  
  Employee findByLastName(String lastName);
  
}
