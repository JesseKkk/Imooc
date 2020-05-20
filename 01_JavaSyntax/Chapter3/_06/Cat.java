package cf.kongjinxing.chap01_03._06;

/**
 * Created by Kong on 2019/12/20.
 */
public class Cat extends Animal {

    public Cat() {
    }

    public Cat(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("小猫" + this.getName() + "在做游戏！");
    }
}
