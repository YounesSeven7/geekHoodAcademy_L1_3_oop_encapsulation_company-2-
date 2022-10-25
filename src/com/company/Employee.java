package com.company;

public class Employee {
    // constants
    public static final String A_MANAGER = "a manager";
    public static final String A_DOCTOR = "a doctor";
    public static final String A_NURSE = "a nurse";
    public static final double TAX = 14.5;
    public static int _id;

    private int id,  workingDays, sandwiches;
    private double amount;
    private String name, specialization;

    public Employee(String name,  String specialization, double amount, int workingDays, int sandwiches) {
        this.id = ++_id;
        this.amount = amount;
        this.workingDays = workingDays;
        this.name = name;
        this.specialization = specialization;
        this.sandwiches = sandwiches;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public int getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(int sandwiches) {
        this.sandwiches = sandwiches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
