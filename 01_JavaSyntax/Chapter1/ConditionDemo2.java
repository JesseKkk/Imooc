package cf.kongjinxing.chap01_01;

import java.util.Scanner;

/**
 * Created by Kong on 2019/11/19.
 */
public class ConditionDemo2 {
    public static void main(String[] args) {
        System.out.println("请输入一个整数");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        if(n % 2 == 0)
        {
            System.out.println(n + "是偶数！");
        }
        else
        {
            System.out.println(n + "是奇数！");
        }
    }
}
