package cf.kongjinxing.chap01_03._08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Kong on 2019/12/24.
 */
public class FileInputTest1 {
    public static void main(String[] args){
        try {
            File f = new File("kong.txt");
            FileInputStream fis = new FileInputStream(f);
            int n = 0;
            int i = 0;

            System.out.print("文件内容为：");
            while ((n = fis.read())!=-1)
            {
                System.out.print((char)n);
                i++;
            }
            System.out.println();

            System.out.println("统计结果：" + f.getName() + "文件中共有" + i + "个字节");
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
