package com.practice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeWithHighestSalaryInDepartment {

    record Employee(Integer id, String name, String departName, Integer salary){}

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Jane", "Math", 6000));
        employees.add(new Employee(2, "Joe", "Chemistry", 4000));
        employees.add(new Employee(3, "Kate", "Math", 7000));
        employees.add(new Employee(4, "Albert", "Physics", 10000));
        employees.add(new Employee(5, "Suu Ann", "Physics", 5000));
        employees.add(new Employee(6, "Zillow", "Math", 5000));
        employees.add(new Employee(7, "Shane", "Chemistry", 5500));

        // Group Employees by Department
        //Map<String, List<Employee>> employeeByDepart = employees.stream().collect(Collectors.groupingBy(Employee::departName, Collectors.toList()));

        // Sort Employee with respect to salary respective to department
        //employeeByDepart.values().forEach(lst -> lst.sort(Comparator.comparing(Employee::salary).reversed()));

        // Highest Salaries
        //employeeByDepart.entrySet().stream().forEach( e -> System.out.printf("Depart: %s, Employee: %s, Salary: %d\r\n", e.getKey(), e.getValue().get(0).name, e.getValue().get(0).salary) );

        // Group Employees by Department
        Map<String,List<Employee>> employeeByDept = employees.stream().collect(Collectors.groupingBy(e->e.departName, Collectors.toList()));
        System.out.println(employeeByDept);

        // Sort Employee with respect to salary respective to department
        employeeByDept.values().stream().forEach(lst -> lst.sort(Comparator.comparing(Employee::salary).reversed()));

        // Highest Salaries
        employeeByDept.entrySet().stream().forEach(entry ->
                System.out.printf("Department: %s, Highest Salary: %d of Employee: %s\r\n",
                        entry.getKey(), entry.getValue().get(0).salary, entry.getValue().get(0).name) );


    }
}
