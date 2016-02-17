public class Intern implements Employee{

    double hourlyWage;
    double wage;
    int hoursWorked;
    String idNumber;

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

    public int getHours() {
        return this.hoursWorked;
    }

    public int compareTo(Object o) {
        Intern pay = (Intern)o;
        if (this.wage > pay.wage)
            return 1;
        if (this.wage < pay.wage)
            return -1;
        else return 0;
    }
}
