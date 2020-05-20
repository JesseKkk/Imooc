package cf.kongjinxing.chap01_02._01.manage;

/**
 * Created by Kong on 2019/12/16.
 */
public class Staff {
    /**
     * 成员属性：员工姓名、工号、年龄、性别、所属部门、职务
     */
    private String staffNa;
    private String staffNu;
    private int age;
    private String sex;
    private Department staffDepartment;
    private Position staffPosition;

    //无参构造方法
    public Staff() {}

    //带参构造方法，实现对员工姓名、工号、年龄、性别、职务的赋值
    public Staff(String staffNa, String staffNu, int age, String sex, Position staffPosition)
    {
        this.setStaffNa(staffNa);
        this.setStaffNu(staffNu);
        this.setAge(age);
        this.setSex(sex);
        this.setStaffPosition(staffPosition);
    }

    //带参构造方法，实现全部属性
    public Staff(String staffNa, String staffNu, int age, String sex,
                 Department staffDepartment, Position staffPosition)
    {
        this.setStaffNa(staffNa);
        this.setStaffNu(staffNu);
        this.setAge(age);
        this.setSex(sex);
        this.setStaffDepartment(staffDepartment);
        this.setStaffPosition(staffPosition);
    }

    public String getStaffNa() {
        return staffNa;
    }

    public void setStaffNa(String staffNa) {
        this.staffNa = staffNa;
    }

    public String getStaffNu() {
        return staffNu;
    }

    public void setStaffNu(String staffNu) {
        this.staffNu = staffNu;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        //限定年龄只能是18-65之间，反之默认为18岁
        if (age < 18 || age > 65) {
            this.age = 18;
        }
        else
        {
            this.age = age;
        }
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        //限定性别只能是“男”或“女”，反之默认为“男”
        if (sex.equals("男") || sex.equals("女"))
        {
            this.sex = sex;
        }
        else
        {
            this.sex = "男";
        }
    }

    public Department getStaffDepartment() {
        if (staffDepartment == null)
            staffDepartment = new Department();
        return staffDepartment;
    }

    public void setStaffDepartment(Department staffDepartment) {
        this.staffDepartment = staffDepartment;
    }

    public Position getStaffPosition() {
        if (staffPosition == null)
            staffPosition = new Position();
        return staffPosition;
    }

    public void setStaffPosition(Position staffPosition) {
        this.staffPosition = staffPosition;
    }

    //员工信息介绍，包括姓名、工号、性别、年龄、职务
    public String info()
    {
        String str = "姓名：" + this.getStaffNa() +
                "\n工号：" + this.getStaffNu() +
                "\n性别：" + this.getSex() +
                "\n年龄：" + this.getAge() +
                "\n职务：" + this.getStaffDepartment().getDepartmentNa()
                +this.getStaffPosition().getPositionNa();
        return str;
    }
}
