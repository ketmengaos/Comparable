public class HourlyEmployee implements Employee {

    double wage;
    double hourlyWage;
    int hoursWorked;
    String idNumber;

    public HourlyEmployee(String idNumber, double hourlyWage, int hoursWorked) {
        this.idNumber = idNumber;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    public double calculatePay() {
        if (this.hoursWorked > 40) {
            this.wage = this.hourlyWage * 40;
            this.wage += (this.hourlyWage * 1.5) * (this.hoursWorked - 40);
            this.wage *= 1.2;
            return this.wage;
        } else {
            this.wage = (hourlyWage * hoursWorked) * 1.2;
            return this.wage;
        }
    }

    public double getPay() {
        return this.hourlyWage;
    }

    public int getHours() {
        return this.hoursWorked;
    }

    public int compareTo(Object o) {
        HourlyEmployee pay = (HourlyEmployee)o;
        if (this.wage > pay.wage)
            return 1;
        if (this.wage < pay.wage)
            return -1;
        else return 0;
    }
}