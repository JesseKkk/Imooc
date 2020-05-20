package cf.kongjinxing.chap01_03._08;

import java.io.File;
import java.io.IOException;

/**
 * Created by Kong on 2019/12/24.
 */
public class FileDemo2 {
    public static void main(String[] args) {
        File f = new File("xing.txt");
        try {
            f.createNewFile();
            System.out.println(f.isAbsolute());
            System.out.println(f.getPath());
            System.out.println(f.getAbsolutePath());
            System.out.println(f.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
