package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployerNewTerminatedTransferred {

    record Employee(Long id, String name, Long departmentId){};

    public static void main(String[] args) {

        List<Employee> yesterdayList = new ArrayList<>();
        yesterdayList.add(new Employee(1l, "Joe", 1l));
        yesterdayList.add(new Employee(2l, "Jane", 2l));
        yesterdayList.add(new Employee(3l, "David", 3l));

        List<Employee> todayList = new ArrayList<>();
        todayList.add(new Employee(1l, "Joe", 1l));
        todayList.add(new Employee(4l, "Mike", 2l));
        todayList.add(new Employee(3l, "David", 4l));

        // Find New Employee, who exist in Today's List but not in Yesterday's
        todayList.stream()
                .filter(e -> !contains(e, yesterdayList))
                .forEach(e -> System.out.printf("New Employee: Id:%d, Name:%s, Department:%d\r\n", e.id, e.name, e.departmentId));

        // Find Terminated Employee, who was in Yesterday's List but not in Today's List
        yesterdayList.stream()
                .filter(e -> !contains(e, todayList))
                .forEach(e -> System.out.printf("Terminated Employee: Id:%d, Name:%s, Department:%d\r\n", e.id, e.name, e.departmentId));

        // Find Employee Department Transferred, who was in different department yesterday
        yesterdayList.stream()
                .filter(e -> isDepartTransferred(e, todayList))
                .forEach(e -> System.out.printf("Department Changed Employee: Id:%d, Name:%s, Department:%d\r\n", e.id, e.name, e.departmentId));

    }

    static boolean contains(Employee e, List<Employee> employees) {
        return employees.stream().anyMatch(_e -> _e.id == e.id && _e.name.equals(e.name));
    }

    static boolean isDepartTransferred(Employee e, List<Employee> employees) {
        return employees.stream().anyMatch(_e -> _e.id == e.id && _e.name.equals(e.name) && _e.departmentId != e.departmentId);
    }

}
