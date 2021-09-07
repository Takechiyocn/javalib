package squality.variableAccessor;

import squality.variableAccessor.Employee;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author kan
 * 不要编写返回引用可变对象的访问器方法
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee staff = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        // raise salary by 5%
        staff.raiseSalary(5);
        System.out.println("name = " + staff.getName() + ", salary = " + staff.getSalary() + ", hireDay = " + staff.getHireDay());

        // 不要编写返回引用可变对象的访问器方法：date.set()
        // 此处Date对象为可变对象，应使用只有访问器方法的LocalDate对象
        double tenYearsInMilliSeconds = 10 * 365.25 * 24 * 60 * 60 * 1000;
        Date d = staff.getHireDay();
        d.setTime(d.getTime() - (long) tenYearsInMilliSeconds);
        System.out.println("name = " + staff.getName() + ", salary = " + staff.getSalary() + ", hireDay = " + staff.getHireDay());
    }
}


