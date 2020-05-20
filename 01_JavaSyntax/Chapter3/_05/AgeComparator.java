package cf.kongjinxing.chap01_03._05;

import java.util.Comparator;

/**
 * Created by Kong on 2019/12/20.
 */
public class AgeComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        int a = o1.getAge();
        int b = o2.getAge();
        return b-a;
    }
}
