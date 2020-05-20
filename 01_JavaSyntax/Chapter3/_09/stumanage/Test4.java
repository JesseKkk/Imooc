package cf.kongjinxing.chap01_03._09.stumanage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Kong on 2019/12/29.
 */
public class Test4 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("Songs.txt");
            byte[] b = new byte[10];
            fis.read(b,1,5);
            System.out.println(new String(b));
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }  catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
