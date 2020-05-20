package cf.kongjinxing.chap01_02._02;

/**
 * Created by Kong on 2019/12/2.
 */
public class Cat {
    private String name;
    private int month;
    private double weight;
    private String species;

    //static：静态成员
    public static int price;

    //构造代码块
    {
        System.out.println("我是构造代码块1");
    }

    static {
        System.out.println("我是静态代码块");
    }

    public Cat(){
        System.out.println("我是宠物猫");
    }

    //创建get/set方法
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
        if (month <= 0)
            System.out.println("宠物猫年龄必须大于0");
        else
            this.month = month;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void eat()
    {
        System.out.println("售价是" +Cat.price + "的" + this.name + "吃鱼");
    }

    public static void run()
    {
        //静态方法不能直接访问同一个类的非静态成员变量， 只能直接调用同一个类中的静态成员
        //只能通过对象实例化后，对象.成员方法的方式访问非静态成员
        System.out.println("售价是" +Cat.price + "的快跑");
    }

    public void run(String name)
    {
        {
            System.out.println("我是代码块");
        }
        System.out.println(name + "快跑");
        {
            System.out.println("我是代码块");
        }
    }
}
