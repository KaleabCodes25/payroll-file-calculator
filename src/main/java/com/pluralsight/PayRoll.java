package com.pluralsight;

import jdk.nio.mapmode.ExtendedMapMode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;

public class PayRoll {
    public static void main(String[] args) {
        String fileName = "employees.csv";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String lines;
            reader.readLine();
            while ((lines = reader.readLine()) != null){
                String[] parts = lines.split("\\|");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double hoursWorked = Double.parseDouble(parts[2]);
                double payRate = Double.parseDouble(parts[3]);


                Employee employee = new Employee (id,name,hoursWorked,payRate);
                System.out.printf("Employee Id:%d, name:%s, Hours Worked:%.2f, Pay rate %.2f, Goss pay is: %.2f \n",
                        employee.getEmployeeId(), employee.getName(), employee.getHoursWorked(), employee.getPayRate(),employee.grossPay());
            }

        }catch (Exception e){
            System.out.println("Error reading file: " + fileName);
        }

    }


}
