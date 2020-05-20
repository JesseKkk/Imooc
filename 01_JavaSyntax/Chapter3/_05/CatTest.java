package cf.kongjinxing.chap01_03._05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Kong on 2019/12/20.
 */
public class CatTest {
    public static void main(String[] args) {
        Cat huahua = new Cat("huahua",5,"英国短毛猫");
        Cat fanfan = new Cat("fanfan",2,"中华田园猫");
        Cat maomao = new Cat("maomao",3,"中华田园猫");

        List<Cat> list = new ArrayList<Cat>();
        list.add(huahua);
        list.add(fanfan);
        list.add(maomao);

        System.out.println("排序前：");
        for (Cat n: list)
        {
            System.out.println(n);
        }

        System.out.println("按名字排序后：");
        Collections.sort(list, new NameComparator());
        for (Cat n: list)
        {
            System.out.println(n);
        }

        System.out.println("按年龄排序后：");
        Collections.sort(list, new AgeComparator());
        for (Cat n: list)
        {
            System.out.println(n);
        }
    }
}
