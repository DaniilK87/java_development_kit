package org.example.homework4;


import java.util.List;

/**
 *    Добавить метод, который ищет сотрудника по стажу (может быть список)
 *  * Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
 *  * Добавить метод, который ищет сотрудника по табельному номеру
 *  * Добавить метод добавления нового сотрудника в справочник
 */
public interface EmployeeService {

    List<Employee> getEmployeeByExperience(int experience);
    List<String> getTelephoneByName(String name);
    Employee getEmployeeByPersonnelNumber(String personnelNumber);
    List<Employee> addNewEmployee();
}
