package squality.parameterInJava;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParaInJavaTest {
    public static void main(String[] args) {
        // Test1: Methods can't modify numeric parameters
        log.info("Testing tripValue:");
        double percent = 10;
        log.info("Before: percent=" + percent);
        tripValue(percent);
        log.info("After: percent" + percent);

        // Test2: Methods can change the state of object parameters
        log.info("Testing tripeSalary:");
        Employee harry = new Employee("Harry", 50000);
        log.info("Before: salary=" + harry.getSalary());
        tripleSalary(harry);
        log.info("After: salary=" + harry.getSalary());

        // Test3: Methods can't attach new objects to object parameters
        log.info("Testing swap:");
        Employee a = new Employee("Alice", 70000);
        Employee b = new Employee("Bob", 60000);
        log.info("Before: a=" + a.getName());
        log.info("Before: b=" + b.getName());
        swap(a, b);
        log.info("After: a=" + a.getName());
        log.info("After: b=" + b.getName());
    }

    public static void tripValue(double x) {
        x = 3 * x;
        log.info("End of method: " + x);
    }

    public static void tripleSalary(Employee e) {
        e.raiseSalary(200);
        log.info("End of method: " + e.getSalary());
    }

    public static void swap(Employee x, Employee y) {
        log.info("Start of method: x=" + x.getName());
        log.info("Start of method: y=" + y.getName());
        Employee temp = x;
        x = y;
        y = temp;
        log.info("End of method: x=" + x.getName());
        log.info("End of method: y=" + y.getName());
    }
}


