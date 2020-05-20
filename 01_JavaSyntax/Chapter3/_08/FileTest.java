package cf.kongjinxing.chap01_03._08;

import java.io.File;
import java.io.IOException;

/**
 * Created by Kong on 2019/12/23.
 */
public class FileTest {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Kong\\Desktop\\kong\\Monday.docx");
        if (!file.exists())
        {
            try {
                file.createNewFile();
                System.out.println("创建文件成功！");
            } catch (IOException e) {
            }
        }

        System.out.println("文件名称：" + file.getName());
        System.out.println("文件上一级目录：" + file.getParent());

        System.out.print("文件/目录：");
        if (file.isDirectory())
        {
            System.out.print("这是一个目录");
        }
        if (file.isFile())
        {
            System.out.println("这是一个文件");
        }

        System.out.print("读写性：");
        if (file.canRead() && file.canWrite())
        {
            System.out.print("这个文件既可读也可写");
        }else if (file.canWrite())
        {
            System.out.println("这个文件可写");
        } else if (file.canRead())
        {
            System.out.println("这个文件可读");
        } else
        {
            System.out.println("这个文件既不可读也不可写");
        }
    }
}
