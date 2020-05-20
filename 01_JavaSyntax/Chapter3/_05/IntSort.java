package cf.kongjinxing.chap01_03._05;

import java.util.*;

/**
 * Created by Kong on 2019/12/20.
 */
public class IntSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        list.add(2);
        list.add(8);
        list.add(3);

        Iterator<Integer> integerIterator = list.iterator();
        while (integerIterator.hasNext())
        {
            System.out.print(integerIterator.next() + "  ");
        }
        System.out.println();

        Collections.sort(list);
        integerIterator = list.iterator();
        while (integerIterator.hasNext())
        {
            System.out.print(integerIterator.next() + "  ");
        }
    }
}
