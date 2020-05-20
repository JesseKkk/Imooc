package cf.kongjinxing.chap01_03._04.list;

import java.util.ArrayList;

/**
 * Created by Kong on 2019/12/19.
 */
public class EmployeeTest {
    public static void main(String[] args) {
        ArrayList array = new ArrayList();

        Employee one = new Employee(1,"张三",5000);
        Employee two = new Employee(2,"李四",5500);
        Employee three = new Employee(1,"赵六",4000);

        array.add(one);
        array.add(two);
        array.add(three);

        System.out.println("员工姓名   员工薪资");
        for (int i = 0; i < array.size(); i++)
        {
            System.out.println(((Employee)(array.get(i))).getName()+"    " +
                    ((Employee)(array.get(i))).getAlary());
        }
    }
}
