package net.andreaskluth.hibernatesample;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

  private final Log log = LogFactory.getLog(getClass());
  
  private EmployeeRepository repository;

  @Autowired
  public EmployeeService(EmployeeRepository repository) {
    this.repository = repository;
  }

  @Transactional
  public void createOrUpdateEmployee(String firstName, String lastName) {
    for (int i = 0; i < 10; i++) {
      Employee employee = repository.findByLastName(lastName);
      if (employee == null) {
        employee = new Employee(firstName, lastName);

        if (i > 0) {
          throw new IllegalStateException("This can never happen!");
        }

      }
      
      log.info("Working with employee: " + employee);
      
      repository.save(employee);
    }
  }
}
