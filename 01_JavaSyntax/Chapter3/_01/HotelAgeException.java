package cf.kongjinxing.chap01_03._01;

/**
 * Created by Kong on 2019/12/10.
 */
public class HotelAgeException extends Exception {
    public HotelAgeException()
    {
        super("18岁以下，80岁以上的住客必须由亲友陪同");
    }
}

class SubException extends HotelAgeException
{

}
