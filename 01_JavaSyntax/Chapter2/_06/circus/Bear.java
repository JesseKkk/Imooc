package cf.kongjinxing.chap01_02._06.circus;

/**
 * Created by Kong on 2019/12/17.
 */
public class Bear extends Animal implements IAct {
    //无参构造器
    public Bear() {
    }

    //带参构造器
    public Bear(String name, int age) {
        super(name, age);
    }

    @Override
    public String love() {
        return "喜欢卖萌";
    }

    @Override
    public String skill() {
        return "挽着花篮，打着雨伞，自立走秀";
    }

    @Override
    public void act() {
        System.out.println("表演者：" + this.getName() +
                "\n年龄：" + this.getAge() +
                "岁\n技能：" + this.skill() +
                "\n爱好：" + this.love());
    }
}
