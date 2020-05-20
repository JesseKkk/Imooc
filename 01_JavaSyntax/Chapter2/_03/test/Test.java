package cf.kongjinxing.chap01_02._03.test;

import cf.kongjinxing.chap01_02._03.animal.Animal;
import cf.kongjinxing.chap01_02._03.animal.Cat;
import cf.kongjinxing.chap01_02._03.animal.Dog;

/**
 * Created by Kong on 2019/12/5.
 */
public class Test {
    public static void main(String[] args) {
        Cat one = new Cat();
        one.setName("花花");
        one.setSpecies("中华田园猫");
        one.eat();
        one.run();
        System.out.println();
        System.out.println("=====================");
        Dog two = new Dog();
        two.setName("妞妞");
        two.setMonth(1);
        two.eat();
        two.sleep();
        System.out.println("=====================");
        Animal three = new Animal();
    }
}
