package cf.kongjinxing.chap01_02._05.innerclass;

/**
 * Created by Kong on 2019/12/17.
 */
//外部类
public class Person {
    int age;

    public Heart getHeart()
    {
        new Heart().temp = 12;
        return new Heart();
    }

    public void eat()
    {
        System.out.println("人会吃东西");
    }

    //成员内部类
    /**
     * 1、内部类在外部使用时，无法直接实例化，需要借由外部类信息才能完成实例化
     * 2、内部类的访问修饰符，可以任意，但是访问范围会受到影响
     * 3、内部类可以直接访问外部类的成员，如果出现同名属性，优先访问内部类中的定义的
     * 4、可以使用外部类.this.成员的方式，访问外部类中同名的信息
     * 5、外部类访问内部类信息，需要通过内部类实例，无法直接访问
     * 6、内部类编译后.class文件 命名：外部类$内部类.class
     * 7、非静态内部类无静态成员
     */
    public class Heart {
        int age = 13;
        int temp =22;
        public String beat()
        {
            eat();
            return Person.this.age + "心脏在跳动";
        }
    }
}
