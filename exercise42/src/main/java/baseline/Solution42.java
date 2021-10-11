/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 first_name last_name
 */

package baseline;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution42 {
    public static void main(String[] args){
        //create a class object to reference class Employee
        Employee emp = new Employee();

        //print the table header to the console (last, first, salary, indents, and hyphens to separate table elements)
        System.out.printf("%-10s%-10s%-10s%n", "Last", "First", "Salary");
        System.out.print("-".repeat(26) + "\n");

        //call printEmployees to print the employee information to the table
        emp.printEmployees("data\\exercise42_input.txt");
    }
}

//class to handle employee information
class Employee{
    //method to print the employee data to the table in the console, takes a string to use as the file path/name
    public void printEmployees(String fileLocale){
        //open try statement to catch exceptions
        try {
            //create scanner object to read from the input file at fileLocale
            Scanner inFile = new Scanner(new File(fileLocale));

            //open while loop to loop while until the next line of the input file is blank
            while(inFile.hasNext()) {
                //create a string of the current line of the input file
                String i = inFile.nextLine();

                //create a string array of the previous string and split it apart using , as the separator
                String[] empData = i.split(",");

                //print the string array contents spaced out appropriately to fit the table in the console
                System.out.printf("%-10s%-10s%-10s%n", empData[0], empData[1], empData[2]);
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.print("File not found.");
        }
    }
}
