package com.hw_2_7_v_2.hw_2_7_v_2.servis;

import com.hw_2_7_v_2.hw_2_7_v_2.exception.EmployeeNotFoundException;
import com.hw_2_7_v_2.hw_2_7_v_2.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartamentServis {

    private final EmployeeServis employeeServis;

    public DepartamentServis(EmployeeServis employeeServis) {
        this.employeeServis = employeeServis;
    }

    public Employee findEmployeeMaxSalaryFromDepartament(int departament) {
        return employeeServis.getAll().stream()
                .filter(employee -> employee.getDepartament() == departament)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee findEmployeeMinSalaryFromDepartament(int departament) {
        return employeeServis.getAll().stream()
                .filter(employee -> employee.getDepartament() == departament)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> findEmployeesFromDepartament(int departament) {
        return employeeServis.getAll().stream()
                .filter(employee -> employee.getDepartament() == departament)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> findEmployees() {
        return employeeServis.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartament));
    }


}
