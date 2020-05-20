package cf.kongjinxing.chap01_02._01.model;

/**
 * Created by Kong on 2019/12/4.
 */
public class Student {
    //成员属性：学号、姓名、性别、年龄
    private String studentNu;
    private String studentName;
    private String studentSex;
    private int studentAge;
    private Subject studentSubject;

    //无参构造方法
    public Student() {
    }

    //带参构造方法，给成员属性赋初值
    public Student(String studentNu, String studentName, String studentSex, int studentAge) {
        this.setStudentNu(studentNu);
        this.setStudentName(studentName);
        this.setStudentSex(studentSex);
        this.setStudentAge(studentAge);
    }

    //带参构造方法，给成员属性赋初值
    public Student(String studentNu, String studentName, String studentSex, int studentAge, Subject studentSubject) {
        this.setStudentNu(studentNu);
        this.setStudentName(studentName);
        this.setStudentSex(studentSex);
        this.setStudentAge(studentAge);
        this.setStudentSubject(studentSubject);
    }

    public String getStudentNu() {
        return studentNu;
    }

    public void setStudentNu(String studentNu) {
        this.studentNu = studentNu;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public Subject getStudentSubject() {
        if (this.studentSubject == null)
            this.studentSubject = new Subject();
        return studentSubject;
    }

    public void setStudentSubject(Subject studentSubject) {
        this.studentSubject = studentSubject;
    }

    //限定性别只能是“男”或者“女”，反之，强制赋值为“男”
    public void setStudentSex(String studentSex) {
        if (studentSex.equals("男") || studentSex.equals("女"))
            this.studentSex = studentSex;
        else
            this.studentSex = "男";
    }

    public int getStudentAge() {
        return studentAge;
    }

    //给年龄设限,限定年龄必须在10-100，反之赋值为18
    public void setStudentAge(int studentAge) {
        if (studentAge < 10 || studentAge > 100)
            this.studentAge = 18;
        else
            this.studentAge = studentAge;
    }

    //学生的自我介绍
    public String introduction()
    {
        String str = "学生信息如下：\n姓名：" + this.getStudentName() + "\n学号 ：" + this.getStudentNu()
                + "\n性别：" + this.getStudentSex() + "\n年龄：" + this.getStudentAge()
                + "\n所报专业名称：" + this.getStudentSubject().getSubjectName()
                + "\n学制年限：" + this.getStudentSubject().getSubjectLife();
        return str;
    }

    /**
     * 学生自我介绍的方法
     * @param subjectName 所学专业名称
     * @param subjectLife 学制年限
     * @return 自我介绍的信息，包括姓名、学号、性别、年龄、所学专业名称、学制年限。
     */
    public String introduction(String subjectName, int subjectLife)
    {
        String str = "学生信息如下：\n姓名：" + this.getStudentName() + "\n学号 ：" + this.getStudentNu()
                + "\n性别：" + this.getStudentSex() + "\n年龄：" + this.getStudentAge()
                + "\n所报专业名称：" + subjectName + "\n学制年限：" + subjectLife;
        return str;
    }

    public String introduction(Subject mySubject)
    {
        String str = "学生信息如下：\n姓名：" + this.getStudentName() + "\n学号 ：" + this.getStudentNu()
                + "\n性别：" + this.getStudentSex() + "\n年龄：" + this.getStudentAge()
                + "\n所报专业名称：" + mySubject.getSubjectName() + "\n学制年限：" + mySubject.getSubjectLife();
        return str;
    }
}
