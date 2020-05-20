package cf.kongjinxing.chap01_03._09.stumanage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kong on 2019/12/27.
 */
public class Test {
    public static void main(String[] args) {
        Student student;
        List<Student> list = new ArrayList<Student>();
        student = new Student("s001","李明");
        list.add(student);
        student = new Student("s002","张三");
        list.add(student);
        System.out.println(list.size());
        student.setChinese(80f);
    }
}
