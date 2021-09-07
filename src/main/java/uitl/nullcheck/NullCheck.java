package uitl.nullcheck;

import squality.parameterInJava.Employee;

/**
 * null判断
 *   1. null是一个有效有意义的返回值：valid response
 *   2. null是无效有误的返回值：invalid response
 *
 * @author moku
 */
public class NullCheck {

    public static void main(String[] args) {

        // 1. null是一个有效有意义的返回值：valid response
        //   -> a. 返回类型是集合即collections，返回空的collections（empty list）
        //      b. 返回空对象（非null对象），使用空对象模式（Null Object pattern）
        nullObjectPattern();

        // 2. null是无效有误的返回值：invalid response
        //   -> a. 明确中断程序，往外抛错误
        // 检查方式：
        //   a. assert语句
        //   b. 抛出空指针异常
        Employee el = new Employee("el",100);
        // 后续处理更改el对象当前状态
        assert el != null : "el is null!";
    }

    /**
     * 1. null是一个有效有意义的返回值：valid response
     */
    private static void nullObjectPattern() {

        Parser parser = new MyParser();
        // 相关处理：parser有可能被设置成null
        // relationProcess(parser);
        parser = null;
        if (parser == null) {
            // 未使用空对象模式
            // 2. null是无效有误的返回值：invalid response
            System.out.println("null parser");
            // now what？
        }

        // 传统调用
        parser =  new MyParser();
        Action action = parser.findAction("name");
        // 因为使用了空对象模式，永远不会进入以下null逻辑
        if (action == null) {
            System.out.println("Called by null check traditional: null action");
        } else {
            System.out.println("Called by null check traditional: not null action");
//            action.printMessage();
        }
        // 对象模式调用1:内部类
        parser.findAction("age").printMessage();
        parser.findAction("unknown").printMessage();

        // 对象模式调用2:Parser接口lambda表达式复写findAction方法
        functionalParser((str) -> {
            if (!("name".equals(str) || "age".equals(str))) {
                return MyParser.IGNORED_ACTION;
            } else {
                // Action接口lambda表达式：复写printMessage方法
                return () -> System.out.println("Called by null object pattern[lambda]:" + str + " matched!");
            }
        });
    }

    public static void functionalParser(Parser parser) {
        // 未明确说明复写方法findAction的执行时机，应显示调用
        Action action = parser.findAction("name");
        // 未明确说明复写方法printMessage的执行时机，应显示调用
        action.printMessage();
    }

    /**
     * 内部类实现函数式接口
     */
    public static class MyParser implements Parser {

        // 匿名类
        //  -> 因静态常量在编译时确定值，而new在运行时堆中创建，故MyParser类最好定义为静态内部类
        public static final Action IGNORED_ACTION = new Action() {
            @Override
            public void printMessage() {
                System.out.println("Called by null object pattern[inner class]:not matched! Should return empty object here.");
            }
        };

        @Override
        public Action findAction(String input) {
            if (!("name".equals(input) || "age".equals(input))) {
                return IGNORED_ACTION;
                // 此处亦可以使用lambda表达式实例化Action对象(具体空对象应如何实现，来确定lambda返回值)
//                return () -> return ?;
            } else {
//                return new Action() {
//                    @Override
//                    public void printMessage() {
//                        System.out.println("Called by null object pattern[inner class]:" + input + " matched!");
//                    }
//                };
                // Action接口lambda表达式
                return () -> System.out.println("Called by null object pattern[inner class]:" + input + " matched!");
            }
        }
    }

}
