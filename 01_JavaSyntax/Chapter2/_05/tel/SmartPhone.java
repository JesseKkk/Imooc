package cf.kongjinxing.chap01_02._05.tel;

/**
 * Created by Kong on 2019/12/9.
 */
public class SmartPhone implements INet, Iphone {
    public void call()
    {
        System.out.println("智能手表可以打电话");
    }

    public void message()
    {
        System.out.println("智能手表可以发短信");
    }

    @Override
    public void network() {
        System.out.println("智能手表可以上网");
    }

    @Override
    public void connection() {
        System.out.println("SmartPhone中的connection");
    }

    @Override
    public void photo() {
        System.out.println("智能手表可以拍照");
    }

//    public void network()
//    {
//        System.out.println("智能手表可以上网");
//    }


}
