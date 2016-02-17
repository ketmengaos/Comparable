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

        int totalHours = 0;
        int counter = 0;
        int numEmployees = 0;
        int lines = 0;

        //This takes the input of the file "List.txt" and places each value in an array in the order:
        //ID Number | Class | Wage | Hours Worked.
        //ID Number | Class | Wage (Or Weekly Payment if Salaried Employee) | Hours Worked.
        //Each value is separated by a space.
        //I used this to extract the number of lines for the arrays that will order the employees.

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

        String word;
        try {
            Scanner scan = new Scanner(new FileReader("List.txt"));

            ArrayList<Employee> employeeArray = new ArrayList<Employee>();

            while (scan.hasNextLine()) {
                word = scan.nextLine();
                String[] employee = word.split("[ ]");

                //Unnecessary, saved for future use if needed.
                //totalHours += Integer.parseInt(employee[3]); // Parses the hours from each time card.

                //Debugging
                System.out.print(employee[0] + " ");
                System.out.print(employee[1] + " ");
                System.out.print(employee[2] + " ");
                System.out.print(employee[3] + " ");
                System.out.println();
                //End Debugging

                double hourlyWage = Double.parseDouble(employee[2]);
                int hoursWorked = Integer.parseInt(employee[3]);

                //Create a new arrays and store each new object inside the arrayslist.

                switch (employee[1]) {
                    case "H":
                        HourlyEmployee hourlyEmployee = new HourlyEmployee(employee[0], hourlyWage, hoursWorked);
                        hourlyEmployee.calculatePay(hourlyWage, hoursWorked);
                        totalHours += hourlyEmployee.getHours(hoursWorked);
                        employeeArray.add(hourlyEmployee);
                        counter++;
                        break;
                    case "S":
                        SalariedEmployee salariedEmployee = new SalariedEmployee(employee[0], hourlyWage, hoursWorked);
                        salariedEmployee.calculatePay(hourlyWage);
                        totalHours += salariedEmployee.getHours(hoursWorked);
                        employeeArray.add(salariedEmployee);
                        counter++;
                        break;
                    case "P":
                        PartTimeEmployee partTimeEmployee = new PartTimeEmployee(employee[0], hourlyWage, hoursWorked);
                        partTimeEmployee.calculatePay(hourlyWage, hoursWorked);
                        totalHours += partTimeEmployee.getHours(hoursWorked);
                        employeeArray.add(partTimeEmployee);
                        counter++;
                        break;
                    case "I":
                        Intern intern = new Intern(employee[0], hourlyWage, hoursWorked);
                        intern.calculatePay();
                        totalHours += intern.getHours(hoursWorked);
                        employeeArray.add(intern);
                        counter++;
                        break;
                    default:
                        System.out.println("Illegal Parameter. Closing program.");
                        System.exit(0);
                        break;
                }
            }

            Collections.sort(employeeArray);

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Please try again.");
            System.exit(0);
        }
        System.out.println("Total Hours Worked: " + totalHours);

    }
}