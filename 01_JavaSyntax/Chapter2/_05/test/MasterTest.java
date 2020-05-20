package cf.kongjinxing.chap01_02._05.test;

import cf.kongjinxing.chap01_02._05.polymorphic.Animal;
import cf.kongjinxing.chap01_02._05.polymorphic.Cat;
import cf.kongjinxing.chap01_02._05.polymorphic.Dog;
import cf.kongjinxing.chap01_02._05.polymorphic.Master;

/**
 * Created by Kong on 2019/12/9.
 */
public class MasterTest {
    public static void main(String[] args) {
        Master master = new Master();
        Cat one = new Cat();
        Dog two = new Dog();
        master.feed(one);
        master.feed(two);
        System.out.println("====================");
        boolean isManyTime = true;
        Animal temp = master.raise(isManyTime);
//        if (isManyTime)
//        {
//            temp = master.hasManyTime();
//        } else
//        {
//            temp = master.hasLittleTime();
//        }
        System.out.println(temp);
    }
}
