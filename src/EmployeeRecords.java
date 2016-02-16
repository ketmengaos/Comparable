import java.io.*;
import java.util.Scanner;

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
        EmployeesArray employeesArray = new EmployeesArray(); //Constructs the employee list.
        employeesArray.employeeList(lines);

        String word;
        try {
            Scanner scan = new Scanner(new FileReader("List.txt"));
            HourlyEmployee hourlyEmployee = new HourlyEmployee();
            SalariedEmployee salariedEmployee = new SalariedEmployee();
            PartTimeEmployee partTimeEmployee = new PartTimeEmployee();
            Intern intern = new Intern();

            while (scan.hasNextLine()) {
                word = scan.nextLine();
                String[] employee = word.split("[ ]");

                totalHours += Integer.parseInt(employee[3]);
                totalHours += Integer.parseInt(employee[3]); // Parses the hours from each time card.

                //Debugging
                System.out.print(employee[0] + " ");
                System.out.print(employee[1] + " ");
                System.out.print(employee[2] + " ");
                System.out.print(employee[3] + " ");
                System.out.println();
                //End Debugging

                double hourlyWage = Double.parseDouble(employee[2]);
                int hoursWorked = Integer.parseInt(employee[3]);

                switch (employee[1]) {
                    case "H":
                        hourlyEmployee.calculatePay(hourlyWage, hoursWorked);
                        hourlyEmployee.getPay(hourlyWage);
                        hourlyEmployee.getHours(hoursWorked);
                        hourlyEmployee.compareTo();
                        break;
                    case "S":
                        salariedEmployee.calculatePay(hourlyWage);
                        salariedEmployee.getPay(hourlyWage);
                        salariedEmployee.getHours(hoursWorked);
                        salariedEmployee.compareTo();
                        break;
                    case "P":
                        partTimeEmployee.calculatePay(hourlyWage, hoursWorked);
                        partTimeEmployee.getPay(hourlyWage);
                        partTimeEmployee.getHours(hoursWorked);
                        partTimeEmployee.compareTo();
                        break;
                    case "I":
                        intern.calculatePay();
                        intern.getPay();
                        intern.getHours(hoursWorked);
                        intern.compareTo();
                        break;
                    default:
                        System.out.println("Illegal Parameter. Closing program.");
                        System.exit(0);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Please try again.");
            System.exit(0);
        }
        System.out.println("Total Hours Worked: " + totalHours);

    }
}