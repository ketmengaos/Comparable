public class HourlyEmployee implements Employee {

    double wage;
    double hourlyWage;
    String idNumber;
    int hoursWorked;
    int empCount = 0;

    public HourlyEmployee(String idNumber, double hourlyWage, int hoursWorked) {
        this.idNumber = idNumber;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    public double calculatePay(double hourlyWage, int hoursWorked) {
        if (hoursWorked > 40) {
            this.wage = hourlyWage * 40;
            this.wage += (hourlyWage * 1.5) * (hoursWorked - 40);
            this.wage *= 1.2;
            this.empCount++;
            return this.wage;
        } else {
            this.wage = (hourlyWage * hoursWorked) * 1.2;
            return this.wage;
        }
    }

    public double getPay(double hourlyWage) {
        return hourlyWage;
    }

    public int getHours(int hoursWorked) {
        return hoursWorked;
    }

    public int compareTo(Object o, String string) {
        HourlyEmployee pay = (pay)o;

        if (this.wage > pay.wage)
            return 1;
        if (this.wage < pay.wage)
            return -1;
        else return 0;
    }

    public String toString() {

    }

}