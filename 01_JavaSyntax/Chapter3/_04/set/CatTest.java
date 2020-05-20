package cf.kongjinxing.chap01_03._04.set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Kong on 2019/12/19.
 */
public class CatTest {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        Cat one = new Cat("花花",2,"英国短腿猫");
        Cat two = new Cat("凡凡",1,"中华田园猫");

        set.add(one);
        set.add(two);

        Iterator iterator = set.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        System.out.println("========================================");
        Cat three = new Cat("凡凡",1,"中华田园猫");
        set.add(three);
        iterator = set.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

    }
}
