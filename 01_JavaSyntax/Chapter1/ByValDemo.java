package cf.kongjinxing.chap01_01;

/**
 * Created by Kong on 2019/11/25.
 */
public class ByValDemo {
    public void swap(int a, int b)
    {
        System.out.println("交换前：a = " + a +",b = " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("交换后：a = " + a +",b = " + b);
    }

    public static void main(String[] args) {
        int a = 5, b = 3;
        System.out.println("交换前：a = " + a +",b = " + b);
        ByValDemo byValDemo = new ByValDemo();
        byValDemo.swap(a, b);
        System.out.println("交换后：a = " + a +",b = " + b);
    }
}
