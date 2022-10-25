package com.company;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Hospital {
    private static int employeesNumber = 1;

    // insert Employees ___________________________________________________________________
    public static List<Employee> insertEmployees(Scanner scanner) {
        List<Employee> employeesList = new ArrayList<>();
        System.out.println("welcome in our hospital system,in our hospital system there are three " +
                "type(specialization) of employees, \n 1- a manager \n 2- a doctor \n 3- a nurse" +
                ",let`s build this system: ");
        while (true) {
            System.out.println("Employee number " + employeesNumber++);
            String name = enterName(scanner);
            String specialization = enterSpecialization(scanner);
            double amount = enterAmount(scanner, specialization);
            // amount after texes
            int workingDays = enterWorkingDays(scanner);
            int sandwich = 0;
            amount = workingDays < 20 ? amount-(20-workingDays)*163.5 : amount;
            sandwich = workingDays > 25 ? workingDays-25 : 0;
            employeesList.add(new Employee(name, specialization, amount, workingDays, sandwich));
            scanner.nextLine();
            System.out.print("Do you need more employees yes or no(or any word) \n ->");
            if(!scanner.nextLine().equals("yes")) break;
        }
        return employeesList;
    }

    private static String enterName(Scanner scanner) {
        System.out.print("Enter (his/her) name -> ");
        return scanner.nextLine();
    }

    private static String enterSpecialization(Scanner scanner) {
        int chose;
        String specialization;
        do {
            System.out.print("1- a manager \n 2- a doctor \n  3- a nurse \n Enter (his/her) specialization chose 1,2 or 3" +
                    " \n  -> ");
            chose = scanner.nextInt();
        }while  (chose <= 0 || chose > 3);
        switch (chose) {
            case 1:
                specialization = Employee.A_MANAGER;
                break;
            case 2:
                specialization = Employee.A_DOCTOR;
                break;
            default:
                specialization = Employee.A_NURSE;
                break;
        }
        return specialization;
    }

    private static double enterAmount(Scanner scanner, String specialization) {
        double amount = 0;
        int min = 0, max = 0;
        String print = "";
        switch (specialization) {
            case Employee.A_NURSE:
                print = "The amount of nurse if from 2000 to 5000";
                min = 2000;
                max = 5000;
                break;
            case Employee.A_DOCTOR :
                print = "The amount of doctor is from 4000 to 8000";
                min = 4000;
                max = 8000;
                break;
            default:
                print = "The amount of manager don't have bounds";
        }
        do {
            System.out.print(print+",Enter (his/her) amount -> ");
            amount = scanner.nextInt();
            /*System.out.println("amount>=min ->" + String.valueOf(amount>=min) + " max == 0 ?true:amount<=max ->"
                    + String.valueOf(max == 0 ?true:amount<=max));*/
        } while (!(amount>=min && (max == 0 ?true:amount<=max)));
        amount = ((100-Employee.TAX) * amount)/100;
        return amount;
    }

    private static int enterWorkingDays(Scanner scanner) {
        int workingDays;
        do {
            System.out.print("Enter (his/her) working days -> ");
            workingDays = scanner.nextInt();
        } while (workingDays < 0 || workingDays > 30);

        return workingDays;
    }

    // print _____________________________________________________________________________
    public static void printEmployees(List<Employee> employeesList) {
        int number = 1;
        System.out.printf("|\t %s \t|\t %s \t|\t %s \t|\t %s \t|\t %s \t|\t %s \t|%n",
                "number", "name", "specialization", "amount", "working days", "sandwiches");
        for (Employee employee:employeesList) {
            System.out.printf("|\t %4s   \t|%9s \t|%14s  \t\t|%9s \t\t|%10s \t\t|%10s \t\t|%n", number, employee.getName(),
                    employee.getSpecialization(), String.format("%02d", (int)employee.getAmount()),
                    String.format("%02d", employee.getWorkingDays()),  String.format("%02d", employee.getSandwiches()));
            number++;
        }

    }



}
