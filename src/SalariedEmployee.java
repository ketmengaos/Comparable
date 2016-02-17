public class SalariedEmployee implements Employee {

    String idNumber;
    double hourlyWage; //Note, hourlyWage will simply refer to their weekly pay.
    double wage;
    int hoursWorked;
    int empCount = 0;

    public SalariedEmployee(String idNumber, double hourlyWage, int hoursWorked) {
        this.idNumber = idNumber;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    public double calculatePay(double hourlyWage) {
        this.wage = hourlyWage * 1.2;
        this.empCount++;
        return this.wage;
    }

    public double getPay(double hourlyWage) {
        return hourlyWage;
    }

    public int getHours(int hoursWorked) {
        return hoursWorked;
    }

    public int compareTo(Object o) {
        SalariedEmployee pay = (pay)o;
        if (this.wage > pay.wage)
            return 1;
        if (this.wage < pay.wage)
            return -1;
        else return 0;
    }
}