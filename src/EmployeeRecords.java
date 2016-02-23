//**********************************************************************************
//******** || Ket-Meng Jimmy Cheng ~ February 17, 2016 ~ EmployeeRecords || ********
//******** || ---------------------------------------------------------- || ********
//******** || This program reads from the List.txt input (specifically)  || ********
//******** || then generates different types objects for each employee,  || ********
//******** || depending on the employee's class. It then creates a list  || ********
//******** || of the employees from highest to lowest paid along with a  || ********
//******** || summary that includes the total payroll for the week, the  || ********
//******** || total number of hours worked, and the number of employees  || ********
//******** || in each class.                                             || ********
//**********************************************************************************

//If, for some reason this doesn't work, all code is listed under https://github.com/ketmengaos/Comparable.

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class EmployeeRecords {

    //Four Classes: Hourly, Salary, Part-Time, Intern
    //Hourly: Hourly wage, 1.5x multiplier for overtime > 40 hours. Has 20% in benefits.
    //Salaried Employee: Fixed weekly base salary + 20% bonus for benefits. No overtime.
    //Part-Time Employee: Paid hourly wage for each hour worked, no benefits/overtime pay.
    //Intern: No pay.

    //Sort highest pay to lowest paid, including benefits.
    //Summary info: Total payroll for the week, total hours by all, number of employees in each class.

    public static void main(String[] arg) {

        double totalPayroll = 0;
        int totalHours = 0;
        String employeeClass;

        int hCount = 0;
        int sCount = 0;
        int pCount = 0;
        int iCount = 0;

        //IMPORTANT:
        //This takes the input of the file "List.txt" and places each value in an array in the order:
        //ID Number | Class | Wage | Hours Worked.
        //ID Number | Class | Wage (Or Weekly Payment if Salaried Employee) | Hours Worked.
        //Each value is separated by a space.
        //I used this to extract the number of lines for the arrays that will order the employees.
        //List is included.

        String word;
        try {
            Scanner scan = new Scanner(new FileReader("List.txt")); //Takes input from List.txt (included, documentation on formatting above.)

            //Create a new array and store each new object inside the arraylist.
            ArrayList<Employee> employeeArray = new ArrayList<Employee>();

            //General loop for continuing to read the document as long as it has a nextLine.
            while (scan.hasNextLine()) {
                word = scan.nextLine();
                String[] employee = word.split("[ ]"); //Splits each line via split method with appropriate regex to cut at every space. Admittedly, had to learn RegEx from the UC San Diego Coursera series on RegEx.

                //This, then, assigns employee[0] to the ID number, employee[1] to the class of employee, employee[2] to the hourly wage, and employee[3] to the hoursWorked.

                double hourlyWage = Double.parseDouble(employee[2]);
                int hoursWorked = Integer.parseInt(employee[3]);
                employeeClass = employee[1];

                //Switch statements for figuring out which kind of employee employee[1] would be, then creating the appropiate objects.
                switch (employee[1]) {
                    case "H": //Hourly
                        HourlyEmployee hourlyEmployee = new HourlyEmployee(employee[0], hourlyWage, hoursWorked, employeeClass);
                        hourlyEmployee.calculatePay();
                        totalPayroll += hourlyEmployee.calculatePay();
                        hourlyEmployee.getPay();
                        totalHours += hourlyEmployee.getHours();
                        employeeArray.add(hourlyEmployee);
                        hCount++;
                        break;
                    case "S": //Salaried
                        SalariedEmployee salariedEmployee = new SalariedEmployee(employee[0], hourlyWage, hoursWorked, employeeClass);
                        salariedEmployee.calculatePay();
                        totalPayroll += salariedEmployee.calculatePay();
                        totalHours += salariedEmployee.getHours();
                        employeeArray.add(salariedEmployee);
                        sCount++;
                        break;
                    case "P": //Part Time
                        PartTimeEmployee partTimeEmployee = new PartTimeEmployee(employee[0], hourlyWage, hoursWorked, employeeClass);
                        partTimeEmployee.calculatePay();
                        totalPayroll += partTimeEmployee.calculatePay();
                        totalHours += partTimeEmployee.getHours();
                        employeeArray.add(partTimeEmployee);
                        pCount++;
                        break;
                    case "I": //Intern
                        Intern intern = new Intern(employee[0], hourlyWage, hoursWorked, employeeClass);
                        intern.calculatePay();
                        totalHours += intern.getHours();
                        employeeArray.add(intern);
                        iCount++;
                        break;
                    default:
                        System.out.println("Illegal Parameter. Closing program.");
                        System.exit(0);
                        break;
                }
            }

            Collections.sort(employeeArray);

            //Makes the sorted employee list.
            System.out.println("Employee List: (Sort: Highest Paid)");
            for (int i = 0; i < employeeArray.size(); i++) {
                System.out.println(employeeArray.get(i)); //Fetches each of the objects stored in our array.
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Please try again.");
            System.exit(0);
        }
        System.out.println();
        System.out.printf("Total Payroll for the Week: $%.2f%n", totalPayroll);
        System.out.println("Total Hours Worked: " + totalHours);
        System.out.println("Total Employees:");
        System.out.println("   Hourly: " + hCount);
        System.out.println("   Salaried: " + sCount);
        System.out.println("   Part-Time:  " + pCount);
        System.out.println("   Interns: " + iCount);
    }
}