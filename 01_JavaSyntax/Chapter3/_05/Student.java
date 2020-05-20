package cf.kongjinxing.chap01_03._05;

/**
 * Created by Kong on 2019/12/20.
 */
public class Student implements Comparable<Student>{
    private int id;
    private int age;
    private String name;

    public Student() {
    }

    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[学号：" + id +
                ", 年龄：" + age +
                ", 姓名：" + name + "]";
    }

    @Override
    public int compareTo(Student o) {
        return this.getId()-o.getId();
    }
}
