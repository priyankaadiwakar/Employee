package com.priyanka.employeeproject;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);

        employeeRepository.save(employeeEntity);
        //employees.add(employee);
        return "Saved Successfully";
    }

    @Override
    public List<Employee> readEmployee() {
        List<EmployeeEntity> employeesList= employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();

        for(EmployeeEntity employeeEntity : employeesList)
        {
            Employee emp =new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setGmail_id(employeeEntity.getGmail_id());
            emp.setPhone_number((employeeEntity.getPhone_number()));

            employees.add(emp);
        }
        return employees;



    }

//    @Override
//    public boolean deleteEmployee(Long id) {
//        //employees.remove(id);
//        EmployeeEntity employeeEntity = new EmployeeEntity();
//        employeeRepository.delete(employeeEntity);
//        return true;
//    }

    @Override
    public boolean deleteEmployee(Long id) {
        Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeRepository.delete(optionalEmployee.get());
            return true;
        } else {
            return false; // Employee with the given ID was not found
        }
    }
}
