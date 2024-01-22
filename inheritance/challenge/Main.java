package inheritance.challenge;

public class Main {

    public static void main(String[] args) {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("John", "1990-01-01", "2020-01-01",
                123456789, "2010-01-01", 10);
        SalariedEmployee salariedEmployee = new SalariedEmployee("Jane", "1990-01-01", "2020-01-01",
                123456789, "2010-01-01", 120000);

        System.out.println("Hourly employee: " + hourlyEmployee.getName() + " " + hourlyEmployee.getBirthDate()
                + " " + hourlyEmployee.collectPay());

        System.out.println("Salaried employee: " + salariedEmployee.getName() + " " + salariedEmployee.getBirthDate()
                + " " + salariedEmployee.collectPay());

        hourlyEmployee.terminate("2020-01-01");
        salariedEmployee.terminate("2020-01-01");
        System.out.println("Retiring salary: " + salariedEmployee.collectPay());
        System.out.println("Double pay: " + hourlyEmployee.getDoublePay());

    }
}
