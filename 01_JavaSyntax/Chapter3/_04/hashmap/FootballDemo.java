package cf.kongjinxing.chap01_03._04.hashmap;

import java.util.*;

/**
 * Created by Kong on 2019/12/19.
 */
public class FootballDemo {
    public static void main(String[] args) {
        Map<Integer, String> test = new HashMap<Integer, String>();
        Scanner sc = new Scanner(System.in);
        Integer key;
        String value;

        for (int i = 0; i < 3; i++)
        {
            System.out.println("请输入年份：");
            key = sc.nextInt();
            System.out.println("请输入国家：");
            value = sc.next();
            test.put(key,value);
        }

        System.out.println("使用迭代器进行输出：");
        Iterator<String> it = test.values().iterator();
        while (it.hasNext())
        {
            System.out.print(it.next() + "  ");
        }
        System.out.println();

        Set<Map.Entry<Integer,String>> set = test.entrySet();
        for (Map.Entry<Integer, String> entry: set)
        {
            System.out.print(entry.getKey() + "-");
            System.out.println(entry.getValue());
        }
    }
}
