package com.hw_2_7_v_2.hw_2_7_v_2.controller;

import com.hw_2_7_v_2.hw_2_7_v_2.model.Employee;
import com.hw_2_7_v_2.hw_2_7_v_2.servis.DepartamentServis;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartamentServis departamentServis;

    public DepartmentController(DepartamentServis departamentServis) {
        this.departamentServis = departamentServis;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeMaxSalaryFromDepartament(@RequestParam("departmentId") int department) {
        return departamentServis.findEmployeeMaxSalaryFromDepartament(department);
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeMinSalaryFromDepartament(@RequestParam("departmentId") int department) {
        return departamentServis.findEmployeeMinSalaryFromDepartament(department);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> findEmployeesFromDepartament(@RequestParam("departmentId") int department) {
        return departamentServis.findEmployeesFromDepartament(department);
    }

    @GetMapping(value = "/all")
    public Map<Integer, List<Employee>> findEmployees() {
        return departamentServis.findEmployees();
    }

}
