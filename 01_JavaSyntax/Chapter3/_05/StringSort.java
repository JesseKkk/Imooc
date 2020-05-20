package cf.kongjinxing.chap01_03._05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Kong on 2019/12/20.
 */
public class StringSort {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("orange");
        list.add("tomato");
        list.add("apple");
        list.add("litchi");
        list.add("banama");

        System.out.println("排序前：");
        for (String a:list)
        {
            System.out.print(a + "  ");
        }
        System.out.println();
        System.out.println("排序后：");
        Collections.sort(list);
        for (String a:list)
        {
            System.out.print(a + "  ");
        }
    }
}
