package com.example.crudtemplatenew.controller;

import com.example.crudtemplatenew.entity.Employee;
import com.example.crudtemplatenew.repository.EmployeeReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Application {
    @Autowired
    private EmployeeReporitory employeeReporitory;

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        employeeReporitory.saveEmployee(employee);
        return employee;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){

        return employeeReporitory.findAll();
    }
    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable("id") Integer id){

        return employeeReporitory.findById(id);
    }

    @PutMapping("/employee}")
    public void update(@RequestBody Employee employee){

        employeeReporitory.update(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable("id") Integer id){
        employeeReporitory.delete(id);
    }
}
