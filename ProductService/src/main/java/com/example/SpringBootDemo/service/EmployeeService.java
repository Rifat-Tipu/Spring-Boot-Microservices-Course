package com.example.SpringBootDemo.service;

import com.example.SpringBootDemo.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String Id);

    String deleteEmployeeById(String id);
}
