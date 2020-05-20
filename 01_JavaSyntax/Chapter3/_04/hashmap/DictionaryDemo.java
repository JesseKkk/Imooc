package cf.kongjinxing.chap01_03._04.hashmap;

import java.util.*;

/**
 * Created by Kong on 2019/12/19.
 */
public class DictionaryDemo {
    public static void main(String[] args) {
        Map<String, String> maptest = new HashMap<String, String>();
        String key;
        String value;

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入三组单词对应的注释，并存放到HashMap中");
        for (int i = 0; i < 3; i++)
        {
            System.out.println("请输入key值（单词）：");
            key = sc.next();
            System.out.println("请输入value值（注释）：");
            value = sc.next();
            maptest.put(key, value);
        }

        Iterator<String> it = maptest.values().iterator();
        while (it.hasNext())
        {
            System.out.print(it.next() + "  ");
        }
        System.out.println();
        System.out.println("===============================");
        System.out.println("通过entrySet方法得到key-value：");
        Set<Map.Entry<String, String>> entrySet = maptest.entrySet();
        for (Map.Entry<String, String> entry:entrySet)
        {
            System.out.print(entry.getKey() + "-");
            System.out.println(entry.getValue());
        }
        System.out.println("===============================");
        System.out.println("请输入要查找的单词：");
        String stringSearch = sc.next();
        Set<String> test = maptest.keySet();
        for (String k : test)
        {
            if (k.equals(stringSearch))
            {
                System.out.println("找到了!" + "键值对为：" + k + maptest.get(k));
            }
        }
    }
}
