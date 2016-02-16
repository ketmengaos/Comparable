public interface Employee extends Comparable {

    public double calculatePay();

    public double getPay(); //aka getWage();

    public int getHours();

    public int compareTo(Object o);

    public String toString();
}