package org.example.homework4;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDB {

    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Ivan", "111","E111",  2));
        employeeList.add(new Employee("Ivan", "222","E112",  1));
        employeeList.add(new Employee("Petr", "222","E113",  2));
        employeeList.add(new Employee("Fedor", "333","E114",  2));
        employeeList.add(new Employee("Sergei", "222","E115",  3));
        employeeList.add(new Employee("Oleg", "222","E116",  3));
        employeeList.add(new Employee("Petr", "222","E117",  3));
        return employeeList;
    }
}
