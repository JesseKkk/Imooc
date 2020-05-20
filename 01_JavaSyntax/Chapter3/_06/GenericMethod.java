package cf.kongjinxing.chap01_03._06;

/**
 * Created by Kong on 2019/12/23.
 */
public class GenericMethod {
    public <T extends Number> void printValue(T t)
    {
        System.out.println(t);
    }

    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
        gm.printValue(124);
        gm.printValue(5f);
//        gm.printValue("hello");
    }
}
