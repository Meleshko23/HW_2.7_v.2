package com.hw_2_7_v_2.hw_2_7_v_2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Employee {

    @JsonProperty("firstName")
    private final String name;

    @JsonProperty("lastName")
    private final String surname;

    private final int departament;

    private final double salary;

    public Employee(String name,
                    String surname,
                    int departament,
                    double salary) {
        this.name = name;
        this.surname = surname;
        this.departament = departament;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getDepartament() {
        return departament;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, departament, salary);
    }

    @Override
    public String toString() {
        return String.format("ФИ: %s %s, отдел: %d, ЗП: %2f", surname, name, departament, salary);
    }

}


