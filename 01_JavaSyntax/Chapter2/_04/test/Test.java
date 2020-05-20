package cf.kongjinxing.chap01_02._04.test;

import cf.kongjinxing.chap01_02._04.singleton.SingletonOne;
import cf.kongjinxing.chap01_02._04.singleton.SingletonTwo;

/**
 * Created by Kong on 2019/12/7.
 */
public class Test {
    public static void main(String[] args) {
        SingletonOne one = SingletonOne.getSingletonOne();
        SingletonOne two = SingletonOne.getSingletonOne();
        System.out.println(one);
        System.out.println(two);
        System.out.println("============================");
        SingletonTwo three = SingletonTwo.getInstance();
        SingletonTwo four = SingletonTwo.getInstance();
        System.out.println(three);
        System.out.println(four);
    }
}
