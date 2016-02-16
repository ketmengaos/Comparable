public class HourlyEmployee implements Employee {

    double wage;
    double hourlyWage;
    double hours;
    int empCount = 0;

    public double calculatePay(double hourlyWage, double hoursWorked) {
        if (hoursWorked > 40) {
            wage = hourlyWage * 40;
            wage += (hourlyWage * 1.5) * (hoursWorked - 40);
            wage *= 1.2;
            this.empCount++;
            return wage;
        } else {
            wage = hourlyWage * hoursWorked;
            return wage;
        }
    }

    public double getPay(double hourlyWage) {
        return hourlyWage;
    }

    public int getHours(int hoursWorked) {
        return hoursWorked;
    }

    public int compareTo(Object o) {
        Time time = (Time)o;
        if(hours != time.hours)
            return hours - time.hours;
        if(minutes != time.minutes)
            return minutes - time.minutes;
        return seconds - time.seconds;
    }

}