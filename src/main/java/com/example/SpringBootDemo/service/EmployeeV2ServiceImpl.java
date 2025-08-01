package com.example.SpringBootDemo.service;

import com.example.SpringBootDemo.entity.EmployeeEntity;
import com.example.SpringBootDemo.error.EmployeeNotFoundException;
import com.example.SpringBootDemo.model.Employee;
import com.example.SpringBootDemo.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId()==null || employee.getEmailId().isEmpty())
        {
            employee.setEmployeeId(UUID.randomUUID().toString());

        }

        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee,entity);
        employeeRepository.save(entity);
        return employee;

    }

    @Override
    public List<Employee> getAllEmployees() {
         List<EmployeeEntity> employeeEntities=employeeRepository.findAll();
         List<Employee>employees=employeeEntities.
                 stream()
                 .map(employeeEntity -> {
                     Employee employee = new Employee();
                     BeanUtils.copyProperties(employeeEntity,employee);
                     return employee;
                 }).collect(Collectors.toList());
            return employees;
    }

    @Override
    public Employee getEmployeeById(String Id) {
        EmployeeEntity employeeEntity=employeeRepository.findById(Id).get();
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
        return "Employee deleted with id: "+id;
    }
}
