/**
 * @author kan
 * 静态方法，静态变量，静态常量相关
 */
public class staticSQMTest {

    public static void main(String[] args) {

        Employee[] staff = new Employee[2];

        // 静态常量
        System.out.println("静态常量（类常量）调用：" + Employee.PI);

        // 静态域：将域定义为static，则每个类中只有一个这样的域。
        //   相对而言， 每一个对象对于实例域都有自己的一份拷贝。
        //   比如：Employee的nextId，每一个雇员对象都有属于自己的id，但时共用一个静态域nextId,
        staff[0] = new Employee("A", 100);
        staff[1] = new Employee("B", 200);

        // 静态方法
        //   1.一个方法不需要访问对象状态，其所需参数都是通过显示参数提供（如Math.pow）
        System.out.println("2的3次幂：" + Math.pow(2, 3));
        //   2.一个方法只需要访问类的静态域
        for (Employee e : staff) {
            // 不应该通过类实例访问静态成员
            System.out.println("name = " + e.getName() + ", id = " + e.getId() + ", staticId = " + Employee.getStaticId());
        }
    }
}

