package cf.kongjinxing.chap01_03._09.stumanage;

import java.util.Objects;

/**
 * Created by Kong on 2019/12/26.
 */
public class Student {
    private String stuNum;//学号
    private  String stuName;//姓名
    private float math;//数学成绩
    private float chinese;//语文成绩

    //无参构造器
    public Student() {
    }

    /**
     * 带参构造器
     * @param stuNum 学号
     * @param stuName 姓名
     */
    public Student(String stuNum, String stuName) {
        this.setStuNum(stuNum);
        this.setStuName(stuName);
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public float getMath() {
        return math;
    }

    public void setMath(float math) {
        //若成绩超出0-100范围，默认为：80
        if (math >= 0f && math <= 100f)
        {
            this.math = math;
        }
        else
        {
            this.math = 80f;
        }
    }

    public float getChinese() {
        return chinese;
    }

    public void setChinese(float chinese) {
        //若成绩超出0-100范围，默认为：80
        if (chinese >= 0f && chinese <= 100f)
        {
            this.chinese = chinese;
        }
        else
        {
            this.chinese = 80f;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return stuNum.equals(student.stuNum) &&
                stuName.equals(student.stuName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuNum, stuName);
    }

    @Override
    public String toString() {
        return "学生信息：[学号：" + stuNum + ", 姓名：" + stuName + "]";
    }

}
