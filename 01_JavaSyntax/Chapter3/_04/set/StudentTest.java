package cf.kongjinxing.chap01_03._04.set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Kong on 2019/12/19.
 */
public class StudentTest {
    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<Student>();

        Student one = new Student(3,"William",65f);
        Student two = new Student(1,"Tom",87f);
        Student three = new Student(2,"Lucy",95f);

        set.add(one);
        set.add(two);
        set.add(three);
        set.add(three);

        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

}
