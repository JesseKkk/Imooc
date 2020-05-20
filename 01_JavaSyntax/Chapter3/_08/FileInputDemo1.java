package cf.kongjinxing.chap01_03._08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Kong on 2019/12/24.
 */
public class FileInputDemo1 {
    public static void main(String[] args){
        try {
            FileInputStream fis = new FileInputStream("kong.txt");
            int n = 0;
            while ((n = fis.read())!=-1)
            {
                System.out.print((char)n);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
