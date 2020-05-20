package cf.kongjinxing.chap01_02._01.manage;

/**
 * Created by Kong on 2019/12/16.
 */
public class Department {
    /**
     * 成员属性：部门编号、部门名称、员工数组、员工个数
     */
    private String departmentNu;
    private String departmentNa;
    private Staff[] staffArray;
    private int staffNu;

    //无参构造方法
    public Department() {}

    //带参构造实现，实现对部门编号、部门名称的赋值
    public Department(String departmentNu, String departmentNa) {
        this.setDepartmentNu(departmentNu);
        this.setDepartmentNa(departmentNa);
    }

    //带参构造方法，实现对所有属性的赋值
    public Department(String departmentNu, String departmentNa, Staff[] staffArray, int staffNu) {
        this.setDepartmentNu(departmentNu);
        this.setDepartmentNa(departmentNa);
        this.setStaffArray(staffArray);
        this.setStaffNu(staffNu);
    }

    public String getDepartmentNu() {
        return departmentNu;
    }

    public void setDepartmentNu(String departmentNu) {
        this.departmentNu = departmentNu;
    }

    public String getDepartmentNa() {
        return departmentNa;
    }

    public void setDepartmentNa(String departmentNa) {
        this.departmentNa = departmentNa;
    }

    public Staff[] getStaffArray() {
        if (staffArray == null)
            staffArray = new Staff[100];
        return staffArray;
    }

    public void setStaffArray(Staff[] staffArray) {
        this.staffArray = staffArray;
    }

    public int getStaffNu() {
        return staffNu;
    }

    public void setStaffNu(int staffNu) {
        this.staffNu = staffNu;
    }

    /**
     * 在部门中添加员工并统计部门的人数
     * @param sta 员工
     */
    public void addStaff(Staff sta)
    {
        for (int i = 0; i < this.getStaffArray().length; i++)
        {
            if (staffArray[i] == null)
            {
                sta.setStaffDepartment(this);
                staffArray[i] = sta;
                staffNu++;
                return;
            }
        }
    }

    //部门信息介绍，包括部门编号和部门名称
    public String info()
    {
        String str = "部门信息如下：\n部门编号：" + this.getDepartmentNu() +
                "\n部门名称：" + this.getDepartmentNa();
        return str;
    }
}
