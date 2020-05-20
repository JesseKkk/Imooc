package cf.kongjinxing.chap01_02._03.animal;

/**
 * Created by Kong on 2019/12/5.
 */
public class Dog extends Animal {
    private String sex;

    public Dog(){}

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void sleep()
    {
        super.eat();
        System.out.println(this.getName() + "现在" + this.getMonth() + "个月大，它在睡觉~~");
    }

    @Override
    public void eat()
    {
        System.out.println(this.getName() + "最近没有食欲~~");
    }
}
