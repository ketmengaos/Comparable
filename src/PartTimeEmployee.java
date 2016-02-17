public class PartTimeEmployee implements Employee {

    String idNumber;
    double hourlyWage;
    double wage;
    int hoursWorked;
    int empCount = 0;

    public PartTimeEmployee(String idNumber, double hourlyWage, int hoursWorked) {
        this.idNumber = idNumber;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    public double calculatePay(double hourlyWage, double hoursWorked) {
        this.wage = hourlyWage * hoursWorked;
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
        PartTimeEmployee pay = (pay)o;
        if (this.wage > pay.wage)
            return 1;
        if (this.wage < pay.wage)
            return -1;
        else return 0;
    }
}