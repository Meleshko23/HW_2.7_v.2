package com.hw_2_7_v_2.hw_2_7_v_2.servis;

import com.hw_2_7_v_2.hw_2_7_v_2.exception.EmployeeAlreadyAddedException;
import com.hw_2_7_v_2.hw_2_7_v_2.exception.EmployeeNotFoundException;
import com.hw_2_7_v_2.hw_2_7_v_2.exception.EmployeeStorageIsFullException;
import com.hw_2_7_v_2.hw_2_7_v_2.model.Employee;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServis {

    private static final int LIMIT = 10;

    private final Map<String, Employee> employees = new HashMap<>();

    public Employee add(String name, String surname) {
        Employee employee = new Employee(name, surname);
        String key = getKey(name, surname);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.put(key, employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee find(String name, String surname) {
        String key = getKey(name, surname);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(key);
    }

    public Employee remove(String name, String surname) {
        String key = getKey(name, surname);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(key);
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }

    private String getKey(String name,
                          String surname) {
        return name + "|" + surname;
    }
}
