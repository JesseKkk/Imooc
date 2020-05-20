package cf.kongjinxing.chap01_03._06;

import java.util.List;

/**
 * Created by Kong on 2019/12/20.
 */
public class AnimalPlay {

    public void listPlay(List< ? extends Animal> list)
    {
        for (Animal test: list)
        {
            test.play();
        }
    }
}
