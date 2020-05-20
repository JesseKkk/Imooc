package cf.kongjinxing.chap01_03._07.weather;

/**
 * Created by Kong on 2019/12/23.
 */
public class Weather {
    private int temperature;
    private int humidity;
    private boolean flag = false;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public synchronized void generate()
    {
        if (flag)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int n = (int)(Math.random()*40);
        int k = (int)(Math.random()*100);
        this.setTemperature(n);
        this.setHumidity(k);
        System.out.println("生成天气数据 [温度：" + n + "，湿度：" + k + "]");
        flag = true;
        notifyAll();
    }

    public synchronized void read()
    {
        if (!flag)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("读取天气数据 [温度：" + this.getTemperature() + "，湿度：" + this.getHumidity() + "]");
        flag = false;
        notifyAll();
    }

    @Override
    public String toString() {
        return "Weather{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", flag=" + flag +
                '}';
    }

}
