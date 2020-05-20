package cf.kongjinxing.chap01_02._03.animal;

import com.sun.deploy.security.SelectableSecurityManager;

/**
 * Created by Kong on 2019/12/5.
 */
public class Animal {
    private String name = "妮妮";
    private int month = 1;
    private String species = "动物";
    private static int st1= 22;
    private static int st2 = 23;
    public final int temp = 15;

    static {
        System.out.println("我是父类的静态代码块");
    }

    {
        System.out.println("我是父类的构造代码块");
    }

    //父类的构造不允许被继承，不允许被重写
    public Animal(){
        System.out.println("我是父类的无参构造方法");
    }

    public Animal(String name, int month)
    {
        this.name = name;
        this.month = month;
        System.out.println("我是父类的带参构造方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void eat()
    {
        System.out.println(this.getName() + "在吃东西");
    }

    public  boolean equals(Object obj)
    {
        if (obj == null )
            return false;
        Animal temp = (Animal)obj;
        if (temp.getName().equals(this.getName()) && (temp.getMonth() == this.getMonth()))
            return true;
        else
            return false;
    }

    public String toString()
    {
        return "昵称：" + this.getName() + ";年龄：" + this.getMonth();
    }
}
