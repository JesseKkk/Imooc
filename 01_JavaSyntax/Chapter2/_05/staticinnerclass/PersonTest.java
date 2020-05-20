package cf.kongjinxing.chap01_02._05.staticinnerclass;

/**
 * Created by Kong on 2019/12/17.
 */
public class PersonTest {
    public static void main(String[] args) {
        Person lili = new Person();
        lili.age = 12;

        //获取静态内部类对象的实例
        Person.Heart myHeart = new Person.Heart();
        System.out.println(myHeart.beat());

        //访问内部类中的静态成员
        Person.Heart.say();

    }
}
