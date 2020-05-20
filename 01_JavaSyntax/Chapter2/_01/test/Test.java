package cf.kongjinxing.chap01_02._01.test;

import cf.kongjinxing.chap01_02._01.manage.Department;
import cf.kongjinxing.chap01_02._01.manage.Position;
import cf.kongjinxing.chap01_02._01.manage.Staff;

/**
 * Created by Kong on 2019/12/16.
 */
public class Test {
    public static void main(String[] args) {
        //创建部门
        Department oneDepartment = new Department("D001","人事部");
        Department twoDepartment = new Department("D002","市场部");

        //创建职务
        Position onePosition = new Position("P001","经理");
        Position twoPosition = new Position("P002","助理");
        Position threePosition = new Position("P003","职员");

        //创建员工
        Staff one = new Staff("张铭","S001",29,
                "男",onePosition);
        Staff two = new Staff("李艾爱","S002",21,
                "女",twoPosition);
        Staff three = new Staff("孙超","S004",29,
                "男", threePosition);
        Staff four = new Staff("张美美","S005",26,
                "女", threePosition);
        Staff  five= new Staff("蓝迪","S006",37,
                "男", onePosition);
        Staff six = new Staff("米莉","S007",24,
                "女", threePosition);

        //划分部门
        oneDepartment.addStaff(one);
        oneDepartment.addStaff(two);
        oneDepartment.addStaff(three);

        twoDepartment.addStaff(four);
        twoDepartment.addStaff(five);
        twoDepartment.addStaff(six);

        //输出员工信息
        System.out.println(one.info());
        System.out.println("======================");
        System.out.println(two.info());
        System.out.println("======================");
        System.out.println(three.info());
        System.out.println("======================");
        System.out.println(four.info());
        System.out.println("======================");
        System.out.println(five.info());
        System.out.println("======================");
        System.out.println(six.info());
        System.out.println("======================");

        //输出部门统计信息
        System.out.println("人事部共有" + oneDepartment.getStaffNu() + "名员工");
        System.out.println("市场部共有" + twoDepartment.getStaffNu() + "名员工");


    }
}
