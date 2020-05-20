package cf.kongjinxing.chap01_02._06.circus;

/**
 * Created by Kong on 2019/12/17.
 */
public class Lion extends Animal implements IAct {
    //新增属性：颜色、性别
    private String color;
    private String sex;

    //无参构造方法
    public Lion() {
    }

    //带参构造方法
    public Lion(String name, int age, String color, String sex) {
        super(name, age);
        this.setColor(color);
        this.setSex(sex);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String love() {
        return "喜欢吃各种肉类";
    }

    @Override
    public String skill() {
        return "擅长钻火圈";
    }

    @Override
    public void act() {
        System.out.println("表演者：" + this.getName() +
                "\n年龄：" + this.getAge() +
                "岁\n性别：" + this.getSex() +
                "狮\n毛色：" + this.getColor() +
                "\n技能：" + this.skill() +
                "\n爱好：" + this.love());
    }
}
