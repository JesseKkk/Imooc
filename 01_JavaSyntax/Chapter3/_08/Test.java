package cf.kongjinxing.chap01_03._08;

import java.io.*;

/**
 * Created by Kong on 2019/12/24.
 */
public class Test {

    public void transWriteByBuf(BufferedWriter bw, String str) throws IOException {
        bw.write(str);
        bw.flush();
    }

    public void transReadByBuf(BufferedReader br) throws IOException {
        String str = null;
        while ((str = br.readLine())!= null)
        {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        String str = "你好吗?\n我很好！";
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter
                    (new FileOutputStream("kong.txt")));
            test.transWriteByBuf(bw,str);

            BufferedReader br = new BufferedReader(new FileReader("kong.txt"));
            test.transReadByBuf(br);
            bw.close();
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
