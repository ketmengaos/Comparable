import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class EmployeeRecords {

    //Four Classes: Hourly, Salary, Part-Time, Intern
    //Hourly: Hourly wage, 1.5x multiplier for overtime > 40 hours.
    //Salaried Employee: Fixed weekly base salary + 20% bonus for benefits. No overtime.
    //Part-Time Employee: Paid hourly wage for each hour worked, no benefits/overtime pay.
    //Intern: No pay.

    //Sort highest pay to lowest paid, including benefits.
    //Summary info: Total payroll for the week, total hours by all, number of employees in each class.

    public static void main(String[] arg) {

        double totalPayroll = 0;
        int totalHours = 0;
        int numEmployees = 0;
        String employeeClass;

        int hCount = 0;
        int sCount = 0;
        int pCount = 0;
        int iCount = 0;

        //This takes the input of the file "List.txt" and places each value in an array in the order:
        //ID Number | Class | Wage | Hours Worked.
        //ID Number | Class | Wage (Or Weekly Payment if Salaried Employee) | Hours Worked.
        //Each value is separated by a space.
        //I used this to extract the number of lines for the arrays that will order the employees.

        //Legacy Code - To be Removed
        /*
        try {
            BufferedReader reader = new BufferedReader(new FileReader("List.txt"));
            while (reader.readLine() != null)
                lines++;
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException Error.");
        } catch (IOException e) {
            System.out.print("IO Exception Error.");
        }
        */

        String word;
        try {
            Scanner scan = new Scanner(new FileReader("List.txt")); //Takes input from List.txt (included, documentation on formatting above.)

            ArrayList<Employee> employeeArray = new ArrayList<Employee>();

            while (scan.hasNextLine()) {
                word = scan.nextLine();
                String[] employee = word.split("[ ]");

                //Unnecessary, saved for future use if needed.
                //totalHours += Integer.parseInt(employee[3]); // Parses the hours from each time card.

                //Debugging
                /*
                System.out.print(employee[0] + " ");
                System.out.print(employee[1] + " ");
                System.out.print(employee[2] + " ");
                System.out.print(employee[3] + " ");
                System.out.println();
                */
                //End Debugging

                double hourlyWage = Double.parseDouble(employee[2]);
                int hoursWorked = Integer.parseInt(employee[3]);
                employeeClass = employee[1];

                //Create a new arrays and store each new object inside the arrayslist.

                switch (employee[1]) {
                    case "H":
                        HourlyEmployee hourlyEmployee = new HourlyEmployee(employee[0], hourlyWage, hoursWorked, employeeClass);
                        hourlyEmployee.calculatePay();
                        totalPayroll += hourlyEmployee.calculatePay();
                        hourlyEmployee.getPay();
                        totalHours += hourlyEmployee.getHours();
                        employeeArray.add(hourlyEmployee);
                        hCount++;
                        break;
                    case "S":
                        SalariedEmployee salariedEmployee = new SalariedEmployee(employee[0], hourlyWage, hoursWorked, employeeClass);
                        salariedEmployee.calculatePay();
                        totalPayroll += salariedEmployee.calculatePay();
                        totalHours += salariedEmployee.getHours();
                        employeeArray.add(salariedEmployee);
                        sCount++;
                        break;
                    case "P":
                        PartTimeEmployee partTimeEmployee = new PartTimeEmployee(employee[0], hourlyWage, hoursWorked, employeeClass);
                        partTimeEmployee.calculatePay();
                        totalPayroll += partTimeEmployee.calculatePay();
                        totalHours += partTimeEmployee.getHours();
                        employeeArray.add(partTimeEmployee);
                        pCount++;
                        break;
                    case "I":
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

            System.out.println("Employee List: (Sort: Highest Paid)");
            for(int i = 0; i < employeeArray.size(); i++) {
                System.out.println(employeeArray.get(i));

            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Please try again.");
            System.exit(0);
        }
        System.out.println();
        System.out.println("Total Payroll for the Week: " + totalPayroll);
        System.out.println("Total Hours Worked: " + totalHours);
        System.out.println("Total Employees:");
        System.out.println("Hourly Employees: " + hCount);
        System.out.println("Salaried Employees:" + sCount);
        System.out.println("Part-Time Employees:  " + pCount);
        System.out.println("Interns: " + iCount);
    }
}