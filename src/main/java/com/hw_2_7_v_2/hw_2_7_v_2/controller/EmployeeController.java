package com.hw_2_7_v_2.hw_2_7_v_2.controller;


import com.hw_2_7_v_2.hw_2_7_v_2.model.Employee;
import com.hw_2_7_v_2.hw_2_7_v_2.servis.EmployeeServis;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")


public class EmployeeController {

    private final EmployeeServis employeeServis;

    public EmployeeController(EmployeeServis employeeServis) {
        this.employeeServis = employeeServis;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String name,
                                @RequestParam("lastName") String surname) {
        return employeeServis.add(name, surname);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String name,
                                @RequestParam("lastName") String surname) {
        return employeeServis.find(name, surname);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String name,
                                 @RequestParam("lastName") String surname) {
        return employeeServis.remove(name, surname);
    }

    @GetMapping("/all")
    public List<Employee> getAll() {
        return employeeServis.getAll();
    }

}
