package cf.kongjinxing.chap01_03._08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Kong on 2019/12/24.
 */
public class FileOutputDemo2 {
    public static void main(String[] args) {
        FileOutputStream fos;
        FileInputStream fis;
        int n = 0;
        byte[] b = new byte[1024];
        try {
            fis = new FileInputStream("11.jpg");
            fos = new FileOutputStream("11copy.jpg");
            long startTime = System.currentTimeMillis();

            while ((n = fis.read(b))!=-1)
            {
                fos.write(b,0,n);
            }
            long endTime = System.currentTimeMillis();
            System.out.println(endTime-startTime);

            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
