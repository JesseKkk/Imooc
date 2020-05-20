package cf.kongjinxing.chap01_01;

import java.util.Scanner;

/**
 * Created by Kong on 2019/11/22.
 */
public class MathDemo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字：");
        int n = sc.nextInt();

        int i = 1;
        int s = 0;
        /*
        while (i <= n)
        {
            s = s + i;
            i++;
        }
         */

        do {
            s = s + i;
            i++;
        }while(i <= n);

        System.out.println("1-" + n + "之间的累加和为" + s);
    }
}
