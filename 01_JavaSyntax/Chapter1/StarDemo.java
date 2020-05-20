package cf.kongjinxing.chap01_01;

import java.util.Scanner;

/**
 * Created by Kong on 2019/11/24.
 */
public class StarDemo {
    public static void main(String[] args) {
        System.out.println("输出菱形星号图形：");

        for (int i = 1; i <= 3; i++)
        {
            int j = 1;
            for (; j <= 3; j++ )
            {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
