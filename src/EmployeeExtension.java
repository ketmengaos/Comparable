public class EmployeeExtension {

    int hoursWorked;
    double hourlyWage;
    double wage;
    String idNumber;
    String employeeClass;

    public EmployeeExtension(String idNumber, double hourlyWage, int hoursWorked, String employeeClass) {
        this.idNumber = idNumber;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
        this.employeeClass = employeeClass;
    }

    //Allows us to obtain the wage.
    public double getPay() {
        return this.hourlyWage;
    }

    //Allows us to obtain the hours worked.
    public int getHours() {
        return this.hoursWorked;
    }

    //Used to compare to the other objects.
    public int compareTo(Object o) {
        Employee otherType = (Employee) o; //Had a tricky time wrapping my head around casting, then I had to figure out how to extract the pay from the subclass of the interface.
        double oWage = otherType.calculatePay();
        if (this.wage > oWage)
            return -1;
        else if (this.wage < oWage)
            return 1;
        else return 0;
    }

    //Standard toString stuff.
    public String toString() {
        return this.idNumber + " " + this.employeeClass + " " + this.hourlyWage + " " + this.hoursWorked;
    }
}
