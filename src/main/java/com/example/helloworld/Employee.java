package com.example.helloworld;

public class Employee {
    private int employeeCode;
    private String employeeName;
    private int employeeAge;
    private String dateOfBirth;

    public Employee() {

    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Employee(int employeeCode, String employeeName, int employeeAge, String dateOfBirth) {
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.dateOfBirth = dateOfBirth;
    }


}
