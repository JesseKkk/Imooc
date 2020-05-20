package cf.kongjinxing.chap01_03._09.stumanage;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kong on 2019/12/27.
 */
public class Test2 {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<Student>();
        List<Student> list2 = new ArrayList<Student>();
        Student stu = new Student("s001","孔金星");
        list1.add(stu);
        list2.addAll(list1);
        System.out.println(list1.get(0).getChinese());
        list2.get(0).setChinese(80f);
        System.out.println(list1.get(0).getChinese());
    }
}
