package com.example.SpringBootDemo.controller;

import com.example.SpringBootDemo.model.Employee;
import com.example.SpringBootDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    @Qualifier("employeeServiceImpl")
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public Employee save(@RequestBody Employee employee)
    {
        return employeeService.save(employee);
    }

    @GetMapping
   public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
   }
   @GetMapping("/{Id}")
   public Employee getEmployeeById(@PathVariable String Id)
   {
       return employeeService.getEmployeeById(Id);
   }
   @DeleteMapping("/{Id}")
   public String deleteEmployeeById(@PathVariable String Id)
   {
      return employeeService.deleteEmployeeById(Id);
   }

}
