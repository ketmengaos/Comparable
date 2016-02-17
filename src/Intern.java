public class Intern implements Employee{

    String idNumber;
    double hourlyWage;
    double wage;
    int hoursWorked;

    public Intern(String idNumber, double hourlyWage, int hoursWorked) {
        this.idNumber = idNumber;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    public double calculatePay() {
        this.wage = 0;
        return 0;
    }

    public double getPay() {
        return 0;
    }

    public int getHours(int hoursWorked) {
        return hoursWorked;
    }

    public int compareTo(Object o) {
        Employee otherEmployee = (Employee)o;

        if (this.wage > otherPay)
            return 1;
        if (this.wage < otherPay)
            return -1;
        else return 0;
    }
}
