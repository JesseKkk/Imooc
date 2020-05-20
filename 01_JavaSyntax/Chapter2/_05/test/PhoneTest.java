package cf.kongjinxing.chap01_02._05.test;

import cf.kongjinxing.chap01_02._05.tel.*;

/**
 * Created by Kong on 2019/12/9.
 */
public class PhoneTest {
    public static void main(String[] args) {
        FourthPhone phone = new FourthPhone();
        phone.call();
        phone.message();
        phone.vedio();
        phone.music();
        phone.photo();
        phone.network();
        System.out.println("================");
        Iphone ip = new FourthPhone();
        ip.photo();
        ip = new Camera();
        ip.photo();
        System.out.println("================");
        System.out.println(INet.TEMP);
        INet net = new SmartPhone();
        System.out.println(net.TEMP);
        net.connection();
        INet.stop();
        System.out.println("================");
        INet net2 = new SmartPhone();
        net2.connection();
        Iphone ip2 = new SmartPhone();
        ip2.connection();
        System.out.println("================");
        INet net3 = new FourthPhone();
        net3.connection();
        Iphone ip3 = new FourthPhone();
        ip3.connection();
    }
}
