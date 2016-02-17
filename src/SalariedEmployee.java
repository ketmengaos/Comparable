public class SalariedEmployee implements Employee {

    double hourlyWage; //Note, hourlyWage will simply refer to their weekly pay.
    double wage;
    int hoursWorked;
    String idNumber;

    public SalariedEmployee(String idNumber, double hourlyWage, int hoursWorked) {
        this.idNumber = idNumber;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
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
        SalariedEmployee pay = (SalariedEmployee) o;
        if (this.wage > pay.wage)
            return 1;
        if (this.wage < pay.wage)
            return -1;
        else return 0;
    }
}