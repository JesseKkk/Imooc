package cf.kongjinxing.chap01_03._05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Kong on 2019/12/20.
 */
public class StudentsTest {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();

        Student one = new Student(40,20, "peter");
        Student two = new Student(28,5,"angel");
        Student three = new Student(35,18,"tom");

        list.add(one);
        list.add(two);
        list.add(three);

        System.out.println("按年龄排序前：");
        for (Student test: list)
        {
            System.out.println(test);
        }

        System.out.println("按年龄排序后：");
        Collections.sort(list);
        for (Student test: list)
        {
            System.out.println(test);
        }
    }
}
