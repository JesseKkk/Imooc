package cf.kongjinxing.chap01_03._06;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kong on 2019/12/20.
 */
public class Test {
    public static void main(String[] args) {
        List<Dog> one = new ArrayList<>();
        Dog dog1 = new Dog("巴迪");
        Dog dog2 = new Dog("豆豆");
        one.add(dog1);
        one.add(dog2);

        AnimalPlay ay = new AnimalPlay();
        ay.listPlay(one);

        List<Cat> two = new ArrayList<>();
        Cat cat1 = new Cat("花花");
        Cat cat2 = new Cat("凡凡");
        two.add(cat1);
        two.add(cat2);
        ay.listPlay(two);



    }
}
