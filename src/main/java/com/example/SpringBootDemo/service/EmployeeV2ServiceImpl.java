package com.example.SpringBootDemo.service;

import com.example.SpringBootDemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService{

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }

    @Override
    public Employee getEmployeeById(String Id) {
        return null;
    }

    @Override
    public String deleteEmployeeById(String id) {
        return "";
    }
}
