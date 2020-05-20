package cf.kongjinxing.chap01_03._08;

import java.io.*;

/**
 * Created by Kong on 2019/12/24.
 */
public class GoodsTest {
    public static void main(String[] args) {
        Goods goods1 = new Goods("gd001","电脑",3000);
        try {
            FileOutputStream fos = new FileOutputStream("kong.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            FileInputStream fis = new FileInputStream("kong.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            //将对象信息写入文件
            oos.writeObject(goods1);
            oos.writeBoolean(true);
            oos.flush();

            //读对象信息
            Goods goods = (Goods)ois.readObject();
            System.out.println(goods);
            System.out.println(ois.readBoolean());

            fis.close();
            ois.close();
            fos.close();
            oos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
