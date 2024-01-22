package inheritance.challenge;

public class Main {

    public static void main(String[] args) {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("John", "1990-01-01", "2020-01-01",
                123456789, "2010-01-01", 10);
        System.out.println(hourlyEmployee.collectPay());
        hourlyEmployee.getDoublePay();


        SalariedEmployee salariedEmployee = new SalariedEmployee("Jane", "1990-01-01", "2020-01-01",
                123456789, "2010-01-01", 120000);
        System.out.println(salariedEmployee.collectPay());
        salariedEmployee.retire();
        System.out.println(salariedEmployee.collectPay());
    }
}
