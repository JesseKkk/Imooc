package cf.kongjinxing.chap01_03._09.stumanage;

import java.util.*;

/**
 * Created by Kong on 2019/12/26.
 */
public class School {
    private Map<String, BanJi> schoolMap;

    /**
     * 无参构造器，新建班级集合
     */
    public School()
    {
        schoolMap = new HashMap<String, BanJi>();
    }

    /**
     * 添加班级
     * @param banJi 班级
     */
    public void addBanJi(BanJi banJi)
    {
        BanJi bj = searchByName(banJi.getClassName());
        if (bj == null)
        {
            schoolMap.put(banJi.getClassName(),banJi);
            System.out.println("班级添加成功！");
        }
        else
        {
            System.out.println("班级已经存在，添加失败！");
        }
    }

    /**
     * 通过班级名称查询班级
     * @param className 班级名称
     * @return 班级
     */
    public BanJi searchByName(String className)
    {
        BanJi bj = null;
        for (String b: schoolMap.keySet())
        {
            if (b.equals(className))
            {
                bj = schoolMap.get(b);
                break;
            }
        }
        return bj;
    }


    /**
     * 删除班级
     * @param banJi 班级
     */
    public void deteBanJi(BanJi banJi)
    {
        BanJi bj = searchByName(banJi.getClassName());
        if (bj == null)
        {
            System.out.println("无此班级，删除失败！");
        }
        else
        {
            schoolMap.remove(banJi.getClassName());
            System.out.println("班级删除成功！");
        }
    }


    /**
     * 语文或数学科目的平均分
     * @param banJi 班级
     * @param subject 科目
     * @return 语文或数学平均分
     */
    public Float scoreAverage(BanJi banJi, String subject)
    {
        float sum = 0f;
        int n = banJi.getStuList().size();
        if (n == 0)
        {
            return 0f;
        }
        else
        {
            if (subject == "chinese") {
                for (Student s : banJi.getStuList()) {
                    sum = sum + s.getChinese();
                }
            }
            else if (subject == "math")
            {
                for (Student s : banJi.getStuList()) {
                    sum = sum + s.getMath();
                }
            }
            return (float)(sum/n);
        }
    }


    /**
     * 各班语文/数学成绩平均分由大到小排序
     */
    public void sortByAverage(String subject) {
        Map<String, Float> map = new HashMap<String, Float>();
        if (subject == "chinese")
        {
            System.out.println("语文成绩由大到小的排序顺序为：");
        }else if (subject == "math") {
            System.out.println("数学成绩由大到小的排序顺序为");
        }

        for (BanJi bj : schoolMap.values()) {
            //将班级名称和班级科目的平均分通过Map对应起来
            map.put(bj.getClassName(), scoreAverage(bj, subject));
        }

        //实现Map按值排序
        //首先将map.entrySet()转换为list
        List<Map.Entry<String, Float>> list = new ArrayList<Map.Entry<String, Float>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list, new Comparator<Map.Entry<String, Float>>() {
            @Override
            public int compare(Map.Entry<String, Float> o1, Map.Entry<String, Float> o2) {
                return (int)(o2.getValue()-o1.getValue());
            }
        });

        //排序后顺序输出
        for (Map.Entry<String,Float> mapping:list)
        {
            System.out.println(mapping.getKey() + "的平均分：" + mapping.getValue());
        }
    }


    /**
     * 显示所有班级名称
     */
    public void displayBanJiName()
    {
        System.out.println("所有班级名称为:");
        for (BanJi bj: schoolMap.values())
        {
            System.out.println(bj.getClassName());
        }
    }

    public Map<String, BanJi> getSchoolMap() {
        return schoolMap;
    }

    public void setSchoolMap(Map<String, BanJi> schoolMap) {
        this.schoolMap = schoolMap;
    }
}
