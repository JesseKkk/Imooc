package cf.kongjinxing.chap01_03._08;

import java.io.File;
import java.io.IOException;

/**
 * Created by Kong on 2019/12/23.
 */
public class FileDemo {
    public static void main(String[] args) {

//        File file1 = new File("C:\\Users\\Kong\\Desktop\\kong\\xing.txt");
//        File file1 = new File("C:\\Users","Kong\\Desktop\\kong\\xing.txt");
        File file =new File("C:\\Users");
        File file1 = new File(file,"Kong\\Desktop\\kong\\xing.txt");

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());

        //创建目录
        File file2 = new File("C:\\Users\\Kong\\Desktop\\kong\\jin\\kjx");
        if (!file2.exists())
        {
            file2.mkdirs();
            System.out.println(file2.getName());
        }

        //创建文件
        if (!file1.exists())
        {

            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
