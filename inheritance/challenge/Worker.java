package inheritance.challenge;

import java.time.LocalDate;
import java.time.Period;

public class Worker {
    private String name;
    private String birthDate;
    private String endDate;

    public Worker(String name, String birthDate, String endDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.endDate = endDate;
    }

    public int getAge() {
        return Period.between(LocalDate.parse(birthDate), LocalDate.now()).getYears();
    }

    public double collectPay() {
        return 0.0;
    }
    public String getName() {
        return name;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public void terminate(String endDate) {
        this.endDate = endDate;
    }

}
