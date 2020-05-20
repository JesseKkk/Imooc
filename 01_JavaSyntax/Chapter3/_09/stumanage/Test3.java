package cf.kongjinxing.chap01_03._09.stumanage;

/**
 * Created by Kong on 2019/12/29.
 */

class ExceptionTest
{
    public void method()
    {
        try
        {
            System.out.println("进入到try块");
            return;
        }
        catch (Exception e)
        {
            System.out.println("异常发生了");
        }
        finally {
            System.out.println("进入到finally块");
        }
        System.out.println("后续代码");
    }
}

public class Test3 {
    public static void main(String[] args) {
        ExceptionTest test = new ExceptionTest();
        test.method();
    }
}
