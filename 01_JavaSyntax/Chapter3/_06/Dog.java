package cf.kongjinxing.chap01_03._06;

/**
 * Created by Kong on 2019/12/20.
 */
public class Dog extends Animal {

    public Dog() {
    }

    public Dog(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("小狗" + this.getName() + "在做游戏！");
    }
}
