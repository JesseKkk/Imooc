package cf.kongjinxing.chap01_03._01;

/**
 * Created by Kong on 2019/12/10.
 */
public class TryDemoFive {
    public static void main(String[] args) {
        try {
            testTree();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testOne() throws HotelAgeException {
        throw new HotelAgeException();
    }

    public static void testTwo() throws Exception {
        try {
            testOne();
        } catch (HotelAgeException e) {
            throw new Exception("我是新的异常1", e);
        }
    }

    public static void testTree() throws Exception {
        try {
            testTwo();
        } catch (Exception e) {
            Exception e1 = new Exception("我是新的异常2");
            e1.initCause(e);
            throw e1;
//            throw new Exception("我是新的异常2");
        }
    }
}
