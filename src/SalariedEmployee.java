public class SalariedEmployee implements Employee {

    double hourlyWage; //Note, hourlyWage will simply refer to their weekly pay.
    double wage;
    int hoursWorked;
    String idNumber;
    String employeeClass;

    public SalariedEmployee(String idNumber, double hourlyWage, int hoursWorked, String employeeClass) {
        this.idNumber = idNumber;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
        this.employeeClass = employeeClass;
    }

    public double calculatePay() {
        this.wage = this.hourlyWage * 1.2;
        return this.wage;
    }

    public double getPay() {
        return this.hourlyWage;
    }

    public int getHours() {
        return this.hoursWorked;
    }

    public int compareTo(Object o) {
        Employee otherType = (Employee)o;
        double oWage = otherType.calculatePay();
        if (this.wage > oWage)
            return -1;
        else if (this.wage < oWage)
            return 1;
        else return 0;
    }

    public String toString() {
        return this.idNumber + " " + this.employeeClass + " " + this.hourlyWage + " " + this.hoursWorked;
    }
}