package cf.kongjinxing.chap01_03._09.stumanage;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Kong on 2019/12/26.
 */

public class TestDemo {
    //Student类测试
    public void testStudent()
    {
        //测试构造器
        Student stu1 = new Student("s001","张三");
        Student stu2 = new Student("s002","李四");
        Student stu3 = new Student("s002","李四");
        System.out.println(stu1);
        System.out.println(stu2);
        System.out.println(stu3);

        //测试equals方法
        System.out.println(stu1.equals(stu2));
        System.out.println(stu2.equals(stu3));
    }

    //BanJi类测试
    public void testBanJi()
    {

        //测试添加学生到班级和显示班级所有学生信息
        BanJi bj1 = new BanJi("s001","火箭班");
        Student stu1 = new Student("s001","张三");
        Student stu2 = new Student("s002","李四");
        Student stu3 = new Student("s002","李四");
        bj1.addStudent(stu1);
        bj1.addStudent(stu2);
        bj1.addStudent(stu3);
        bj1.displayAllStudent();

        //测试查询和删除学生
        Student stu4 = bj1.serachStudentByNum("s001");
        bj1.deleteStudent("s002");
        bj1.displayAllStudent();

        //测试添加成绩
        bj1.insertChineseScore("s001",60f);
        bj1.insertMathScore("s001",120f);
        System.out.println(stu1.getChinese());
        System.out.println(stu1.getMath());
    }

    //School类测试
    public void testSchool() {
        //测试班级添加和显示所有班级
        BanJi bj1 = new BanJi("s001", "一班");
        Student stu1 = new Student("s0011", "张三");
        bj1.addStudent(stu1);

        BanJi bj2 = new BanJi("s002", "二班");
        Student stu2 = new Student("s0021", "李四");
        bj2.addStudent(stu2);

//        BanJi bj4 = new BanJi("s002", "四班");
//        Student stu4 = new Student("s0021", "李四");
//        bj4.addStudent(stu4);

        BanJi bj3 = bj2;

        School sl = new School();
        sl.addBanJi(bj1);
        sl.addBanJi(bj2);
        sl.addBanJi(bj3);
        sl.displayBanJiName();

        //根据名称查询班级和删除班级
        sl.deteBanJi(bj1);
//        sl.deteBanJi(bj4);
        sl.displayBanJiName();

        BanJi bj5 = sl.searchByName("二班");
        System.out.println(bj5.getClassName());
    }

    //School类中各班语文/数学成绩按平均分由大到小排序测试
    public void testAverage()
    {

        //测试求平均成绩
        School sl = new School();
        BanJi bj1 = new BanJi("s001","一班");
        Student stu1 = new Student("s0011","张三");
        Student stu2 = new Student("s0012","李四");
        Student stu3 = new Student("s0013","王五");
        bj1.addStudent(stu1);
        bj1.addStudent(stu2);
        bj1.addStudent(stu3);
        bj1.insertChineseScore("s0011",0f);
        bj1.insertChineseScore("s0012",10f);
        bj1.insertChineseScore("s0013",0f);
        bj1.insertMathScore("s0011",10f);
        bj1.insertMathScore("s0012",20f);
        bj1.insertMathScore("s0013",30f);
        sl.addBanJi(bj1);
////        System.out.println(sl.scoreAverage(bj1,"chinese"));
////        System.out.println(sl.scoreAverage(bj1,"math"));

        //测试各班语文/数学成绩排序
        BanJi bj2 = new BanJi("s002","二班");
        sl.addBanJi(bj2);
        //语文成绩排序
        sl.sortByAverage("chinese");
        //数学成绩排序
        sl.sortByAverage("math");
    }

    public void mainMenu()
    {
        System.out.println("********************************************");
        System.out.println("                 主菜单                      ");
        System.out.println("                1--班级管理                  ");
        System.out.println("                2--学校管理                  ");
        System.out.println("                0--退出                      ");
        System.out.println("********************************************");
    }

    public void schoolMenu()
    {
        System.out.println("********************************************");
        System.out.println("               学校管理                     ");
        System.out.println("        1--创建班级                         ");
        System.out.println("        2--删除班级                         ");
        System.out.println("        3--通过班级名称查询班级信息          ");
        System.out.println("        4-对各班语文成绩按平均分由大到小排序  ");
        System.out.println("        5-对各班数学成绩按平均分由大到小排序  ");
        System.out.println("        6--显示所有班级名称                  ");
        System.out.println("        9--返回上一级菜单                    ");
        System.out.println("********************************************");
    }

    public void banJiMenu()
    {
        System.out.println("********************************************");
        System.out.println("               班级管理                      ");
        System.out.println("        1--添加学生信息到主学生列表           ");
        System.out.println("        2--添加学生信息到普通班级             ");
        System.out.println("        3--通过学号查询学生信息               ");
        System.out.println("        4--输入班级的语文成绩                 ");
        System.out.println("        5--输入班级的数学成绩                 ");
        System.out.println("        6--删除学生信息                       ");
        System.out.println("        7--显示所有学生信息                   ");
        System.out.println("        9--返回上一级菜单                     ");
        System.out.println("********************************************");
    }

    public void test()
    {
        School sl = new School();
        BanJi bj = null;
        Student student = null;
        BanJi bj1 = new BanJi("s000","主学生列表");
        Scanner sc = new Scanner(System.in);
        int input;
        int input1;
        int input2;

        while (true)
        {
            mainMenu();
            System.out.println("请输入对应数字进行列表管理");
            try {
                input = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("输入的数据格式有误");
                sc.next();
                continue;
            }
            if (input == 0)
            {
                System.out.println("退出成功！");break;
            }
            switch (input)
            {
                case 1:
                    while(true)
                    {
                        banJiMenu();
                        System.out.println("请输入对应的数字进行列表管理");
                        try {
                            input1 = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("输入的数据格式有误");
                            sc.next();
                            continue;
                        }
                        if (input1 == 9)
                        {
                            break;
                        }
                        switch (input1)
                        {
                            case 1:
                                System.out.println("添加学生信息到主学生列表");
                                System.out.println("请输入要添加的学生个数：");
                                int input11 = sc.nextInt();
                                for (int i = 1; i <= input11; i++)
                                {
                                    System.out.println("请输入第" + i + "学生信息");
                                    System.out.println("请输入学生id：");
                                    String str = sc.next();
                                    student = bj1.serachStudentByNum(str);
                                    if (student == null) {

                                        System.out.println("请输入学生姓名：");
                                        String str1 = sc.next();
                                        student = new Student(str, str1);
                                        bj1.addStudent(student);
                                    } else
                                    {
                                        System.out.println("该学生已经存在，请重新输入：");
                                        i--;
                                    }
                                }
                                bj1.displayAllStudent();
                                break;
                            case 2:
                                System.out.println("添加学生信息到普通班级");
                                System.out.println("请输入要添加的班级名称");
                                String str2 = sc.next();
                                bj = sl.searchByName(str2);
                                if (bj == null)
                                {
                                    System.out.println("未查询到此班级");
                                }
                                else
                                {
                                    System.out.println("请输入要添加的学生个数：");
                                    int input12 = sc.nextInt();
                                    for(int i = 1; i <= input12; i++)
                                    {
                                        System.out.println("请输入第" + i + "学生信息");
                                        System.out.println("请输入学生id：");
                                        String str = sc.next();
                                        student = bj1.serachStudentByNum(str);
                                        if (student == null)
                                        {
                                            System.out.println("请输入学生姓名：");
                                            String str1 = sc.next();
                                            Student stu1 = new Student(str, str1);
                                            bj.addStudent(stu1);
                                            bj1.addStudent(stu1);
                                        }
                                        else
                                        {
                                            bj.addStudent(student);
                                        }
                                    }
                                    bj1.displayAllStudent();
                                    bj.displayAllStudent();
                                }
                                break;
                            case 3:
                                System.out.println("通过学号查询学生信息");
                                System.out.println("请输入要查询的班级名称：");
                                String str3 = sc.next();
                                bj = sl.searchByName(str3);
                                if (bj == null)
                                {
                                    System.out.println("该班级不存在");
                                }
                                else
                                {
                                    System.out.println("请输入要查询的学生id");
                                    String input12 = sc.next();
                                    student = bj.serachStudentByNum(input12);
                                    if (student == null)
                                    {
                                        System.out.println("该学生信息在" + bj.getClassName() + "不存在");
                                    }
                                    else
                                    {
                                        System.out.println("学生信息：");
                                        System.out.println(student);
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("输入班级的语文成绩");
                                System.out.println("请输入班级的名称");
                                String str4 = sc.next();
                                bj = sl.searchByName(str4);
                                if (bj == null)
                                {
                                    System.out.println("该班级不存在");
                                }
                                else
                                {
                                    if (bj.getStuList().size() == 0)
                                    {
                                        System.out.println("该班级尚未添加学生");
                                    }
                                    else
                                    {
                                        for (Student s: bj.getStuList())
                                        {
                                            System.out.println(s);
                                            System.out.println("请输入学生语文成绩：");
                                            float input12 = sc.nextFloat();
                                            s.setChinese(input12);
                                            System.out.println("添加语文成绩成功");
                                        }
                                    }

                                }
                                break;
                            case 5:
                                System.out.println("输入班级的数学成绩");
                                System.out.println("请输入班级的名称");
                                String str5 = sc.next();
                                bj = sl.searchByName(str5);
                                if (bj == null)
                                {
                                    System.out.println("该班级不存在");
                                }
                                else
                                {
                                    if (bj.getStuList().size() == 0)
                                    {
                                        System.out.println("该班级尚未添加学生");
                                    }
                                    else
                                    {
                                        for (Student s: bj.getStuList())
                                        {
                                            System.out.println(s);
                                            System.out.println("请输入学生数学成绩：");
                                            float input12 = sc.nextFloat();
                                            s.setMath(input12);
                                            System.out.println("添加数学成绩成功");
                                        }
                                    }

                                }
                                break;
                            case 6:
                                System.out.println("删除学生信息");
                                System.out.println("请输入班级的名称");
                                String str11 = sc.next();
                                bj = sl.searchByName(str11);
                                if (bj == null)
                                {
                                    System.out.println("该班级不存在");
                                }
                                else
                                {
                                    System.out.println("请输入学生id:");
                                    String str12 = sc.next();
                                    student = bj.serachStudentByNum(str12);
                                    if (student == null)
                                    {
                                        System.out.println("没有找到id：" + str12 + "的学生信息");
                                    }
                                    else
                                    {
                                        bj.deleteStudent(str12);
                                    }
                                }
                                break;
                            case 7:
                                System.out.println("显示所有学生信息");
                                System.out.println("请输入班级的名称");
                                String str7 = sc.next();
                                bj = sl.searchByName(str7);
                                if (bj == null)
                                {
                                    System.out.println("该班级不存在");
                                }
                                else
                                {
                                    bj.displayAllStudent();
                                }
                                break;
                            default: System.out.println("输入有误，没有对应的操作！");break;
                        }
                    }
                    break;
                case 2:
                    while (true)
                    {
                        schoolMenu();
                        System.out.println("请输入对应的数字进行列表管理");
                        try {
                            input2 = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("输入的数据格式有误");
                            sc.next();
                            continue;
                        }
                        if (input2 == 9)
                        {
                            break;
                        }
                        switch (input2)
                        {
                            case 1:
                                System.out.println("创建班级");
                                System.out.println("请输入班级编号：");
                                String str1 = sc.next();
                                System.out.println("请输入班级名称：");
                                String str2 = sc.next();
                                bj = sl.searchByName(str2);
                                if (bj == null)
                                {
                                    bj = new BanJi(str1,str2);
                                    sl.addBanJi(bj);
                                }
                                else
                                {
                                    System.out.println("该班级已经存在，创建失败");
                                }
                                break;
                            case 2:
                                System.out.println("删除班级");
                                System.out.println("请输入班级名称");
                                String str3 = sc.next();
                                bj = sl.searchByName(str3);
                                if (bj == null)
                                {
                                    System.out.println("该班级不存！");
                                }
                                else
                                {
                                    sl.deteBanJi(bj);
                                }
                                break;
                            case 3:
                                System.out.println("通过班级名称查询班级信息");
                                System.out.println("请输入班级名称");
                                String str4 = sc.next();
                                bj = sl.searchByName(str4);
                                if (bj == null)
                                {
                                    System.out.println("该班级不存在");
                                }
                                else
                                {
                                    System.out.println(bj);
                                }
                                break;
                            case 4:
                                System.out.println("对各班语文成绩按平均分由大到小排序");
                                sl.sortByAverage("chinese");
                                break;
                            case 5:
                                System.out.println("对各班数学成绩按平均分由大到小排序");
                                sl.sortByAverage("math");
                                break;
                            case 6:
                                System.out.println("显示所有班级名称");
                                sl.displayBanJiName();
                                break;
                            default: System.out.println("输入有误，没有对应的操作！");break;
                        }
                    }
                    break;
                default:
                    System.out.println("输入有误，没有对应的操作！");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        TestDemo td = new TestDemo();
//        td.testStudent();
//        td.testBanJi();
//        td.testSchool();
//        td.testAverage();
        td.test();
    }
}
