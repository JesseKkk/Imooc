package cf.kongjinxing.chap01_02._01.model;

/**
 * Created by Kong on 2019/12/4.
 */
public class Subject {
    //成员属性：学科名称、学科编号、学制年限、报名选修的学生信息、报名选修的学生个数
    private String subjectName;
    private String subjectNu;
    private int subjectLife;
    private Student[] myStudents;
    private  int studentNum;

    //无参构造函数
    public Subject(){}

    //带参构造，实现对学科名称、编号、学制年限赋值
    public Subject(String subjectName, String subjectNu, int subjectLife)
    {
        this.setSubjectName(subjectName);
        this.setSubjectNu(subjectNu);
        this.setSubjectLife(subjectLife);
    }

    //带参构造，实现对全部属性的赋值
    public Subject(String subjectName, String subjectNu, int subjectLife, Student[] myStudents)
    {
        this.setSubjectName(subjectName);
        this.setSubjectNu(subjectNu);
        this.setSubjectLife(subjectLife);
        this.setMyStudents(myStudents);
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectNu() {
        return subjectNu;
    }

    public void setSubjectNu(String subjectNu) {
        this.subjectNu = subjectNu;
    }

    public int getSubjectLife() {
        return subjectLife;
    }

    public void setSubjectLife(int subjectLife) {
        if (subjectLife <= 0)
            return;
        this.subjectLife = subjectLife;
    }

    public Student[] getMyStudents() {
        if (this.myStudents == null)
            this.myStudents = new Student[200];
        return myStudents;
    }

    public void setMyStudents(Student[] myStudents) {
        this.myStudents = myStudents;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    //专业介绍的方法
    public String info()
    {
        String str = "专业信息如下：\n专业名称：" + this.getSubjectName() + "\n专业编号："
                + this.getSubjectNu() + "\n专业年限：" + this.getSubjectLife();
        return str;
    }

    public void addStudent(Student stu)
    {
        /**
         * 1、将学生保存到数组中
         * 2、将学生个数保存到studentNum
         */
        for (int i = 0; i < this.getMyStudents().length; i++)
        {
            if (this.getMyStudents()[i] == null)
            {
                this.getMyStudents()[i] = stu;
                this.studentNum = i + 1;
                return;
            }

        }
    }
}
