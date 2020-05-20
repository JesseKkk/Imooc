package cf.kongjinxing.chap01_03._01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Kong on 2019/12/10.
 */
public class TryDemoTwo {
    public static void main(String[] args) {
        int result = test();
        System.out.println("one和two的商是：" + result);
    }

    public static int test()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("======运算开始=======");
        try {
            System.out.print("请输入第一个整数：");
            int one = input.nextInt();
            System.out.print("请输入第二个整数：");
            int two = input.nextInt();
            return one/two;
        }catch(ArithmeticException e){
            System.out.println("除数不允许为0");
            return 0;
        }finally {
            System.out.println("======运3算结束=======");
//            return -100000;
        }
    }
}
