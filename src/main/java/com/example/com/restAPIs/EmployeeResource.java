package com.example.com.restAPIs;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
public class EmployeeResource {

    @Autowired
    private EmployeeDao service;

    //retrieving all emp
    @RequestMapping("/employees")
    public List<Employee> retrieveAllEmployees(){
        return service.findAll();
    }
    @RequestMapping("employees/{id}")
    public Employee retrieveEmployee(@PathVariable int id){
        Employee employee=service.findOne(id);
        return employee;
    }

    //post  --- input>>details of emp
    //output >> CREATED and return URI
    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmp(@RequestBody Employee employee){
       Employee savedEmployee= service.save(employee);

       //created
        //  /employees/{id}   savedEmployee.getId()
        URI location =ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedEmployee.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("employees/{id}")
    public Employee deleteEmployee(@PathVariable int id){
        Employee employee=service.deleteById(id);
        return employee;
    }

}
