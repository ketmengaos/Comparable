public class Intern implements Employee{

    double hourlyWage;
    double wage;
    int hoursWorked;
    String idNumber;
    String employeeClass;

    public Intern(String idNumber, double hourlyWage, int hoursWorked, String employeeClass) {
        this.idNumber = idNumber;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
        this.employeeClass = employeeClass;
    }

    public double calculatePay() {
        this.wage = 0;
        return 0;
    }

    public double getPay() {
        return 0;
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
