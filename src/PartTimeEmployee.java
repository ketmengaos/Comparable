public class PartTimeEmployee implements Employee {

    double wage;
    int empCount = 0;

    public double calculatePay(double hourlyWage, double hoursWorked) {
        wage = hourlyWage * hoursWorked;
        this.empCount++;
        return wage;
    }

    public double getPay(double hourlyWage) {
        return hourlyWage;
    }

    public int getHours(int hoursWorked) {
        return hoursWorked;
    }

    public int compareTo(Object o) {

    }
}