package cf.kongjinxing.chap01_02._05.staticinnerclass;

/**
 * Created by Kong on 2019/12/17.
 */
//外部类
public class Person {
//    public static int age = 12;
    int age;

    public Heart getHeart()
    {
        return new Heart();
    }

    public static void eat()
    {
        System.out.println("人会吃东西");
    }

    //静态内部类
    /**
     * 1、静态内部类中，只能直接访问外部类的静态成员，如果需要调用非静态成员，可以通过对象实例
     * 2、静态内部类对象实例时，可以不依赖外部类对象
     * 3、可以通过外部类.内部类.静态成员的方式，访问内部类中的静态成员
     * 4、当内部类属性与外部类属性同名时，默认直接调用内部类的成员；
     *    如果需要访问外部类中的静态属性，则可以通过外部类.属性的方式
     *    如果需要访问外部类中的非静态属性，则可以通过 new 外部类().属性的方式
     * 5、外部内可通过内部类.成员的方式访问静态内部类
     */
    public static class Heart
    {
        public static int age = 13;
        public static void say()
        {
            System.out.println("hello");
        }

        public String  beat()
        {
            eat();
//            return Person.age + "岁的心脏在跳动";
            return new Person().age + "岁的心脏在跳动";
        }
    }
}
