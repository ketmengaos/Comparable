public class SalariedEmployee implements Employee {

    int empCount = 0;
    double wage;

    public double calculatePay(double hourlyWage) {
        wage = hourlyWage * 1.2;
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