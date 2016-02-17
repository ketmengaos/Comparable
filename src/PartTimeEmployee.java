public class PartTimeEmployee implements Employee {

    double hourlyWage;
    double wage;
    int hoursWorked;
    String idNumber;

    public PartTimeEmployee(String idNumber, double hourlyWage, int hoursWorked) {
        this.idNumber = idNumber;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    public double calculatePay() {
        this.wage = this.hourlyWage * this.hoursWorked;
        return this.wage;
    }

    public double getPay() {
        return this.hourlyWage;
    }

    public int getHours() {
        return this.hoursWorked;
    }

    public int compareTo(Object o) {
        PartTimeEmployee pay = (PartTimeEmployee)o;
        if (this.wage > pay.wage)
            return 1;
        if (this.wage < pay.wage)
            return -1;
        else return 0;
    }
}