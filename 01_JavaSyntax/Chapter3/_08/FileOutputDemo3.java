package cf.kongjinxing.chap01_03._08;

import java.io.*;

/**
 * Created by Kong on 2019/12/24.
 */
public class FileOutputDemo3 {
    public static void main(String[] args) {
        FileOutputStream fos;
        BufferedOutputStream bos;
        String str1 = "one.txt";
        String str2 = "two.txt";
        long k,v;

        try {
            //不使用缓冲
            fos = new FileOutputStream(str1);
            long startTime = System.currentTimeMillis();
            for (int n = 0; n < 100000; n++)
            {
                fos.write('a');
            }
            long endTime = System.currentTimeMillis();
            k = endTime - startTime;
            System.out.println(str1 + "不使用缓冲流来写");
            System.out.println("用时为：" + k);

            //使用缓冲
            bos = new BufferedOutputStream(new FileOutputStream(str2));
            startTime = System.currentTimeMillis();
            for (int n = 0; n < 100000; n++)
            {
                bos.write('a');
            }
            bos.flush();
            endTime = System.currentTimeMillis();
            v = endTime - startTime;
            System.out.println(str2 + "使用缓冲流来写");
            System.out.println("用时为：" + v);
            System.out.println("节省用时：" + (k - v));

            fos.close();
            bos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
