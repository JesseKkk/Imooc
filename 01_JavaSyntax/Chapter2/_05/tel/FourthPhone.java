package cf.kongjinxing.chap01_02._05.tel;

/**
 * Created by Kong on 2019/12/9.
 */
public class FourthPhone extends ThirdPhone implements Iphone,INet {
//    public void photo()
//    {
//        System.out.println("手机可以拍照");
//    }

    public void network()
    {
        System.out.println("手机可以上网");
    }

    public void game()
    {
        System.out.println("手机可以玩游戏");
    }

    @Override
    public void photo() {
        System.out.println("手机可以拍照");
    }

    public void connection()
    {
        System.out.println("我是FourthPhone的connection");
    }
}
