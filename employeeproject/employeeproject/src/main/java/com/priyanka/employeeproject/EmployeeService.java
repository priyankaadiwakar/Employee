package com.priyanka.employeeproject;

import java.util.List;

public interface EmployeeService {

     String createEmployee(Employee employee);
     List<Employee> readEmployee();
     boolean deleteEmployee(Long id);
}
