package inheritance.challenge;

import java.time.LocalDate;

public class SalariedEmployee extends Employee {

    private double annualSalary;
    private boolean isRetired;

    public SalariedEmployee(String name, String birthDate, String endDate
            , long employeeId, String hireDate, double annualSalary) {
        super(name, birthDate, endDate, employeeId, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = false;
    }

    public void retire() {
        this.isRetired = true;
        super.terminate(LocalDate.now().toString());
    }

    @Override
    public double collectPay() {
        return !isRetired ? (int) annualSalary / 26 : (int) (annualSalary / 26) * 0.9;
    }

}
