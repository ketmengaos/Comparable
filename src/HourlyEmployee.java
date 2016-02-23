public class HourlyEmployee extends EmployeeExtension implements Employee {

    double wage;
    double hourlyWage;
    double basePay;
    int hoursWorked;
    String idNumber;
    String employeeClass;

    //Constructs the object and it's parameters.
    public HourlyEmployee(String idNumber, double hourlyWage, int hoursWorked, String employeeClass) {
        super(idNumber, hourlyWage, hoursWorked, employeeClass);
        this.idNumber = idNumber;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
        this.employeeClass = employeeClass;
    }

    //Allows us to calculate pay, then returns the pay.
    public double calculatePay() {
        if (this.hoursWorked > 40) {
            basePay = (hoursWorked * hourlyWage) * .2;
            this.wage = this.hourlyWage * 40;
            this.wage += (this.hourlyWage * 1.5) * (this.hoursWorked - 40);
            this.wage += basePay;
            return this.wage;
        } else {
            this.wage = (hourlyWage * hoursWorked) * 1.2;
            return this.wage;
        }
    }
}
