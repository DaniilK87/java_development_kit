package org.example.homework4;


import java.util.ArrayList;
import java.util.List;

public class Employee {

    private static List<Employee> employeeList;
    private String name;
    private String telephoneNumber;
    private String personnelNumber;
    private int experience;


    public Employee(String name, String telephoneNumber, String personnelNumber, int experience) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.personnelNumber = personnelNumber;
        this.experience = experience;
    }

    public Employee() {
    }

    public static List<Employee> getEmployeeList() {
        employeeList = new ArrayList<>();
        return employeeList;
    }

    public String getName() {
        return name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getPersonnelNumber() {
        return personnelNumber;
    }

    public int getExperience() {
        return experience;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setPersonnelNumber(String personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", personnelNumber='" + personnelNumber + '\'' +
                ", experience=" + experience +
                '}';
    }
}
