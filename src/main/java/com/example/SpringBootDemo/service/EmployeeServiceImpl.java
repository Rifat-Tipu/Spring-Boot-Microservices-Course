package com.example.SpringBootDemo.service;

import com.example.SpringBootDemo.error.EmployeeNotFoundException;
import com.example.SpringBootDemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeService{

    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId()==null || employee.getEmailId().isEmpty())
        {
            employee.setEmployeeId(UUID.randomUUID().toString());

        }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String Id) {
        return employees.stream()
                .filter(employee -> employee.getEmployeeId().equalsIgnoreCase(Id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: "+Id));
    }

    @Override
    public String deleteEmployeeById(String id) {
       // employees.removeIf(employee -> employee.getEmployeeId().equalsIgnoreCase(id));
        Employee employee=employees.stream()
                .filter(e -> e.getEmployeeId().equalsIgnoreCase(id))
                .findFirst()
                .get();
        employees.remove(employee);
        return "Employee deleted with id: "+id;
    }
}
