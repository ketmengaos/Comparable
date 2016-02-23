public class PartTimeEmployee extends EmployeeExtension implements Employee {

    double hourlyWage;
    double wage;
    int hoursWorked;
    String idNumber;
    String employeeClass;

    public PartTimeEmployee(String idNumber, double hourlyWage, int hoursWorked, String employeeClass) {
        super(idNumber, hourlyWage, hoursWorked, employeeClass);
        this.idNumber = idNumber;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
        this.employeeClass = employeeClass;
    }

    public double calculatePay() {
        this.wage = this.hourlyWage * this.hoursWorked;
        return this.wage;
    }
}