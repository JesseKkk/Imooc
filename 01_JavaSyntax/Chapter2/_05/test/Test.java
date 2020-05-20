package cf.kongjinxing.chap01_02._05.test;

import cf.kongjinxing.chap01_02._05.polymorphic.Animal;
import cf.kongjinxing.chap01_02._05.polymorphic.Cat;
import cf.kongjinxing.chap01_02._05.polymorphic.Dog;
import com.sun.xml.internal.ws.addressing.WsaActionUtil;

/**
 * Created by Kong on 2019/12/9.
 */
public class Test {
    public static void main(String[] args) {
//        Animal one = new Animal();

        /**
         * 向上转型、隐式转型、自动转型
         * 父类引用指向子类实例，可以调用子类重写父类的方法以及父类派生的方法，无法调用子类独有的方法
         *小类转型为大类
         * 注意：父类中的静态方法无法被子类重写，所以向上转型之后，只能调用父类原有的静态方法
         */
        Animal two = new Cat();
        Animal three = new Dog();
        two.say();
        Cat cat = (Cat)two;
        cat.say();
//        one.eat();
//        two.eat();
////        two.run();
//        three.eat();
//        System.out.println("======================");
//        /**
//         * 向下转型、强制类型转换
//         * 子类引用指向父类对象，此处必须强转，可以调用子类特有的方法
//         * instanceof运算符：返回true/false
//         */
//        if (two instanceof Cat)
//        {
//            Cat temp = (Cat) two;
//            temp.eat();
//            temp.run();
//            System.out.println("Cat");
//        }
//
//        if (two instanceof Animal)
//        {
//            System.out.println("Animal");
//        }
//
//        if (two instanceof  Object)
//        {
//            System.out.println("Object");
//        }

    }
}
