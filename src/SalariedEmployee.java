public class SalariedEmployee extends EmployeeExtension implements Employee {

    protected double hourlyWage; //Note, hourlyWage will simply refer to their weekly pay.
    protected double wage;
    protected int hoursWorked;
    protected String idNumber;
    protected String employeeClass;

    public SalariedEmployee(String idNumber, double hourlyWage, int hoursWorked, String employeeClass) {
        super(idNumber, hourlyWage, hoursWorked, employeeClass);
        this.idNumber = idNumber;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
        this.employeeClass = employeeClass;
    }

    public double calculatePay() {
        this.wage = this.hourlyWage * 1.2;
        return this.wage;
    }
}