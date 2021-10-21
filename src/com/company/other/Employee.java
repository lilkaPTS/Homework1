package com.company.other;

public class Employee {

    private static int counter = 1;

    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(String firstName, String lastName, int salary) {
        this.id = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualSalary() {
        return salary*12;
    }

    public int raiseSalary(int percent) {
        return percent > 0 ? (salary * (100 + percent))/100 : salary; // because the function is called "raise salary"
    }

    @Override
    public String toString() {
        return String.format("Employee[id=%d, name=%s, salary=%d]", id, this.getName(), salary);
    }
}
