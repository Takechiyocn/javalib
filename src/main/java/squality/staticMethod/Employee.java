package squality.staticMethod;

public class Employee {
    private String name;
    private static int staticId = 1;
    private int id;
    // 静态常量
    //   此处为类常量（添加public后可在其他类中调用）
    public static final double PI = 3.14;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    /**
     * 静态方法
     * 静态域属于类，不属于对象。亦即没有this隐式参数
     * 不应该通过类实例访问静态成员
     * @return
     */
    public static int getStaticId() {
        return staticId;
    }
}
