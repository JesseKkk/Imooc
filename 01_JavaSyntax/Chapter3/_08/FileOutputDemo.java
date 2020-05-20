package cf.kongjinxing.chap01_03._08;

import java.io.*;

/**
 * Created by Kong on 2019/12/24.
 */
public class FileOutputDemo {
    public static void main(String[] args) {
        FileInputStream fis;
        FileOutputStream fos;
        File f = new File("kong.txt");
        try {
            fos = new FileOutputStream(f);
            fis = new FileInputStream(f);
            fos.write(50);
            fos.write('a');
            System.out.println(fis.read());
            System.out.println((char)fis.read());
            fos.close();
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
