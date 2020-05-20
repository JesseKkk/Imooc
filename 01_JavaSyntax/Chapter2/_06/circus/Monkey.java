package cf.kongjinxing.chap01_02._06.circus;

/**
 * Created by Kong on 2019/12/17.
 */
public class Monkey extends Animal implements IAct {
    //新增属性：品种
    private String type;

    //无参构造函数
    public Monkey() {
    }

    //带参构造函数
    public Monkey(String name, int age, String type) {
        super(name, age);
        this.setType(type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String love() {
        return "喜欢模仿人的动作表情";
    }

    @Override
    public String skill() {
        return "骑独轮车过独木桥";
    }

    @Override
    public void act() {
        System.out.println("表演者：" + this.getName() +
                "\n年龄：" + this.getAge() +
                "岁\n品种：" + this.getType() +
                "\n技能：" + this.skill() +
                "\n爱好：" + this.love());
    }
}
