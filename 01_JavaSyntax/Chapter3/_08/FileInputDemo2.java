package cf.kongjinxing.chap01_03._08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Kong on 2019/12/24.
 */
public class FileInputDemo2 {
    public static void main(String[] args){
        try {
            FileInputStream fis = new FileInputStream("kong.txt");
            byte[] b = new byte[100];
            fis.read(b);
            System.out.println(new String(b));
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
