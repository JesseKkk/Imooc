package cf.kongjinxing.chap01_02._03.test;

import cf.kongjinxing.chap01_02._03.animal.Animal;

/**
 * Created by Kong on 2019/12/6.
 */
public class TestThree {
    public static void main(String[] args) {
        Animal one = new Animal("花花",2);
        Animal two = new Animal("花花",2);

        //equals:继承Object中equals方法，比较的是两个引用是否指向同一个对象
        boolean flag = one.equals(two);
        System.out.println("one 和 two的引用比较：" + flag);
        System.out.println("one 和 two的引用比较：" + (one == two));
        System.out.println("============================");
        String str1 = new String("hello");
        String str2 = new String("hello");
        flag = str1.equals(str2);
        System.out.println("str1 和 str2的引用比较：" + flag);
        System.out.println("str1 和 str2的引用比较：" + (str1 == str2));
        System.out.println("============================");
        System.out.println(one.toString());
        System.out.println(one);
        System.out.println("============================");
        System.out.println(str1);
    }
}
