package cf.kongjinxing.chap01_03._05;

import java.util.Comparator;

/**
 * Created by Kong on 2019/12/20.
 */
public class NameComparator implements Comparator<Cat> {


    @Override
    public int compare(Cat o1, Cat o2) {
        String name1 = o1.getName();
        String name2 = o2.getName();
        int i= name1.compareTo(name2);
        return i;
    }
}
