package cf.kongjinxing.chap01_03._09.stumanage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kong on 2019/12/26.
 */
public class BanJi {
    private String classId;//班级编号
    private String className;//班级名称
    private List<Student> stuList;//班级学生集合


    /**
     * 无参构造函数，新建班级学生集合
     */
    public BanJi() {
        stuList = new ArrayList<Student>();
    }

    /**
     * 带参构造函数，为班级编号和班级名称赋值，并新建班级学生集合
     *
     * @param classId   班级编号
     * @param className 班级名称
     */
    public BanJi(String classId, String className) {
        this.classId = classId;
        this.className = className;
        stuList = new ArrayList<Student>();
    }

    /**
     * 将学生添加到班级
     * @param stu 学生
     */
    public void addStudent(Student stu) {
        //排除重复添加
        boolean flag = false;
        for (Student s : stuList) {
            if (s.equals(stu)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("学生重复添加，无效！");
        } else {
            stuList.add(stu);
            System.out.println("学生成功添加！");
        }
    }

    /**
     * 通过学号查询学生在班级中是否存在
     * @param stuNum 学号
     * @return 学生
     */
    public Student serachStudentByNum(String stuNum)
    {
        Student stu = null;
        for (Student s:stuList)
        {
            if (s.getStuNum().equals(stuNum))
            {
                stu = s;break;
            }
        }
        return stu;
    }

    /**
     * 添加学生语文成绩
     * @param stuNum 学生编号
     * @param score 学生语文成绩
     */
    public void insertChineseScore(String stuNum, float score)
    {
        Student stu = serachStudentByNum(stuNum);
        if (stu == null)
        {
            System.out.println("无此学生，语文成绩添加失败！");
        }
        else
        {
            stu.setChinese(score);
            System.out.println("学生语文成绩添加成功！");
        }
    }


    /**
     * 添加学生数学成绩
     * @param stuNum 学生编号
     * @param score 学生数学成绩
     */
    public void insertMathScore(String stuNum, float score)
    {
        Student stu = serachStudentByNum(stuNum);
        if (stu == null)
        {
            System.out.println("无此学生，数学成绩添加失败！");
        }
        else
        {
            stu.setMath(score);
            System.out.println("学生数学成绩添加成功！");
        }
    }


    /**
     * 删除学生
     * @param stuNum 学生编号
     */
    public void deleteStudent(String stuNum)
    {
        Student stu = serachStudentByNum(stuNum);
        if (stu == null)
        {
            System.out.println("无此学生，删除无效！");
        }
        {
            stuList.remove(stu);
            System.out.println("学生删除成功！");
        }
    }

    /**
     * 显示班级所有学生信息
     */
    public void displayAllStudent()
   {
       System.out.println( className + "，所有学生信息：");
       for (Student s:stuList)
       {
           System.out.println(s);
       }
   }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Student> getStuList() {
        return stuList;
    }

    public void setStuList(List<Student> stuList) {
        this.stuList = stuList;
    }

    @Override
    public String toString() {
        return "班级信息：[班级编号：" + classId + ", 班级名称：" + className + "]";
    }
}