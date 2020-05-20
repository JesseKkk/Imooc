package cf.kongjinxing.chap01_02._06.circus;

/**
 * Created by Kong on 2019/12/17.
 */
public abstract class Animal {
    //属性：昵称、年龄
    private String name;
    private int age;

    //无参构造器
    public Animal() {
    }

    //带参构造器
    public Animal(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //描述喜好
    public abstract String love();
}
