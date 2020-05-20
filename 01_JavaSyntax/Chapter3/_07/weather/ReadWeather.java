package cf.kongjinxing.chap01_03._07.weather;

/**
 * Created by Kong on 2019/12/23.
 */
public class ReadWeather implements Runnable {
    Weather weather;

    public ReadWeather(Weather weather)
    {
        this.weather = weather;
    }

    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            weather.read();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
