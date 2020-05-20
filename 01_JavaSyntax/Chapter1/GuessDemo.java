package cf.kongjinxing.chap01_01;

import java.util.Scanner;

/**
 * Created by Kong on 2019/11/24.
 */
public class GuessDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("猜一个介于2到10之间的数");
        System.out.println("请输入您猜测的数：");
        int ran = ((int) (Math.random() * 8)) + 2;
        int n = sc.nextInt();

        while (n != ran)
        {
            if (n < ran)
            {
                System.out.println("太小！");
                n = sc.nextInt();
            }
            if(n >ran)
            {
                System.out.println("太大！");
                n = sc.nextInt();
            }
        }
        System.out.println("猜测正确！");
    }
}
