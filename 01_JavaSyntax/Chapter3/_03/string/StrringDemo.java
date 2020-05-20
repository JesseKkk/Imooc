package cf.kongjinxing.chap01_03._03.string;

/**
 * Created by Kong on 2019/12/18.
 */
public class StrringDemo {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("abc");
        str.replace(0,str.length(),"fed--cba");
        str.delete(3,6);
        System.out.println(str);

    }
}
