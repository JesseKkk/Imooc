package cf.kongjinxing.chap01_03._07.weather;

/**
 * Created by Kong on 2019/12/23.
 */
public class GenerateWeather implements Runnable {
    Weather weather;

    public GenerateWeather(Weather weather) {
        this.weather = weather;
    }

    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            weather.generate();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
