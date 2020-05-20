package cf.kongjinxing.chap01_03._07.weather;

/**
 * Created by Kong on 2019/12/23.
 */
public class Test {
    public static void main(String[] args) {
        Weather weather = new Weather();
        new Thread(new GenerateWeather(weather)).start();
        new Thread(new ReadWeather(weather)).start();
    }
}
