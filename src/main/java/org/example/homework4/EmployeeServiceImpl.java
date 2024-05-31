package org.example.homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDB employeeDB= new EmployeeDB();
    private Employee employee = new Employee();
    private Scanner scanner = new Scanner(System.in);


    public Employee addNewEmployee() {
        System.out.println("Добавьте нового сотрудника");
        System.out.println("Введите имя:");
        employee.setName(scanner.next());
        System.out.println("Введите номер телефона:");
        employee.setTelephoneNumber(scanner.next());
        System.out.println("Введите табельный номер:");
        employee.setPersonnelNumber(scanner.next());
        System.out.println("Введите стаж:");
        employee.setExperience(scanner.nextInt());
        return employee;
    }

    @Override
    public List<Employee> getEmployeeByExperience(int experience) {
        List<Employee> list = Employee.getEmployeeList();
        for (Employee e: employeeDB.getAllEmployee()) {
            if (e.getExperience() == experience) {
                list.add(e);
            }
        }
        return list;
    }

    @Override
    public List<String> getTelephoneByName(String name) {
        List<String> list = new ArrayList<>();
        for (Employee e: employeeDB.getAllEmployee()) {
            if (e.getName().equals(name)) {
                list.add(e.getTelephoneNumber());
            }
        }
        return list;
    }

    @Override
    public Employee getEmployeeByPersonnelNumber(String personnelNumber) {
        for (Employee e: employeeDB.getAllEmployee()) {
            if (e.getPersonnelNumber().equals(personnelNumber)) {
                employee = e;
            }
        }
        return employee;
    }
}
