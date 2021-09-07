import java.time.LocalDate;
import java.util.Date;

public class Employee {
    private String name;
    private double salary;
    //    private LocalDate hireDay;
    private Date hireDay;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = new Date(year, month, day);
//        this.hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

//    public LocalDate getHireDay() {
//        return this.hireDay;
//    }

    public Date getHireDay() {
        return this.hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }
}
