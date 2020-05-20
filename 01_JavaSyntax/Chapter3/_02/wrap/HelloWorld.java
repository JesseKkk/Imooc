package cf.kongjinxing.chap01_03._02.wrap;

/**
 * Created by Kong on 2019/12/18.
 */
public class HelloWorld {
    public static void main(String[] args) {
        float f1 = 88.99f;
        String f2 = Float.toString(f1);
        System.out.println("f2 = " + f2);
        String str = "188.55";
        double str2 = Double.parseDouble(str);
        System.out.println("str2 = " + str2);
    }
}
