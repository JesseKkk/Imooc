package cf.kongjinxing.chap01_01;

/**
 * Created by Kong on 2019/11/22.
 */
public class CharDemo {
    public static void main(String[] args) {
        char ch = 'a';
        int count = 1;

        while (ch <= 'z')
        {
            System.out.print(ch + " ");
            if (count % 13 == 0)
                System.out.println();
            count++;
            ch++;
        }
    }
}
