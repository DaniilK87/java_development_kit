package org.example.homework4;


import java.util.List;

/**
 * Создать справочник сотрудников
 * Необходимо:
 * Создать класс справочник сотрудников, который содержит внутри
 * коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
 * Табельный номер
 * Номер телефона
 * Имя
 * Стаж
 * Добавить метод, который ищет сотрудника по стажу (может быть список)
 * Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
 * Добавить метод, который ищет сотрудника по табельному номеру
 * Добавить метод добавления нового сотрудника в справочник
 */
public class Main {

    public static void main(String[] args) {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

        List<Employee> getEmployeeByExperience = employeeService.getEmployeeByExperience(1);
        if (getEmployeeByExperience.isEmpty()) throw new RuntimeException("Сотрудника с таким опытом нет");
        System.out.println(getEmployeeByExperience);

        List<String> getTelephoneByName = employeeService.getTelephoneByName("Ivan");
        if (getTelephoneByName.isEmpty()) throw new RuntimeException("Сотрудника с таким именем нет");
        System.out.println(getTelephoneByName);

        Employee getEmployeeByPersonnelNumber = employeeService.getEmployeeByPersonnelNumber("E117");
        if (getEmployeeByExperience.isEmpty()) throw new RuntimeException("Сотрудника с таким табельным номером нет");
        System.out.println(getEmployeeByPersonnelNumber);

        Employee addNewEmployee = employeeService.addNewEmployee();
        EmployeeDB employeeDB = new EmployeeDB();
        List<Employee> allEmployee = employeeDB.getAllEmployee();
        allEmployee.add(addNewEmployee);
        System.out.println(allEmployee);
    }
}
