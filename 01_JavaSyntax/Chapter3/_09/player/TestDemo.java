package cf.kongjinxing.chap01_03._09.player;


import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Kong on 2019/12/24.
 */
public class TestDemo {

    //对歌曲类Song进行测试
    public void testSong()
    {
        Song song1 = new Song("s001","两只老虎","小太阳");
        Song song2 = new Song("s002","小燕子","风车");
        Song song3 = new Song("s002","小燕子","风车");
        System.out.println(song1);

        //测试对象是否相等
        System.out.println(song1.equals(song2));
        System.out.println(song2.equals(song3));
    }

    //对播放列表PlayList进行测试
    public void testPlayList() {
        Song song1 = new Song("s001", "两只老虎", "小太阳");
        Song song2 = new Song("s002", "小燕子", "风车");
        Song song3 = new Song("s002", "小燕子", "风车");

        //创建播放列表
        PlayList mainPlayList = new PlayList("主播放列表");
        mainPlayList.addToPlayList(song1);
        mainPlayList.addToPlayList(song2);
        mainPlayList.addToPlayList(song3);

        //显示播放列表中的内容
        mainPlayList.displayAllSong();

        //根据歌曲id查询歌曲
        Song song = mainPlayList.searchSongById("s0012");
        if (song != null)
        {
            System.out.println("根据歌曲id查询的歌曲信息为：");
            System.out.println(song);
        }
        else
        {
            System.out.println("该歌曲不存在");
        }

        //根据歌曲名称查询歌曲
        song = mainPlayList.searchSongByName("小燕子");
        if (song != null)
        {
            System.out.println("根据歌曲名称查询的歌曲信息为：");
            System.out.println(song);
        }
        else
        {
            System.out.println("该歌曲不存在");
        }

        //修改歌曲
        Song songUpdate = new Song("s005","蜗牛与黄鹂鸟", "小太阳");
        mainPlayList.updateSong("s002",songUpdate);
        mainPlayList.displayAllSong();

        //删除歌曲
        mainPlayList.deleteSong("s005");
        mainPlayList.displayAllSong();
    }

    //测试播放列表集合类
    public void testPlayListCollection()
    {
        //创建歌曲
        Song song1 = new Song("s001","两只老虎","小太阳");
        Song song2 = new Song("s002","小燕子","风车");

        //创建主播放列表
        PlayList mainPlayList = new PlayList("主播放列表");
        mainPlayList.addToPlayList(song1);
        mainPlayList.addToPlayList(song2);

        //创建我喜欢播放列表
        PlayList myFavoritePlayList = new PlayList("我喜欢");
        myFavoritePlayList.addToPlayList(mainPlayList.getMusicList().get(0));
        myFavoritePlayList.addToPlayList(mainPlayList.getMusicList().get(1));


        //创建播放列表集合
        PlayListCollection playListCollection = new PlayListCollection();

        //添加播放列表
        playListCollection.addPlayList(mainPlayList);
        playListCollection.addPlayList(myFavoritePlayList);
        playListCollection.displayListName();

        //查询播放列表
        PlayList playList = playListCollection.searchPlayListByName("主播放列表");
        playList.displayAllSong();

        //删除播放列表
        playListCollection.deletePlayList(myFavoritePlayList);
        playListCollection.displayListName();


    }

    //主菜单
    public void mainMenu()
    {
        System.out.println("********************************************");
        System.out.println("                 主菜单                      ");
        System.out.println("                1--播放列表管理               ");
        System.out.println("                2--播放器管理                 ");
        System.out.println("                0--退出                      ");
        System.out.println("********************************************");
    }

    //播放列表管理菜单
    public void playListMenu()
    {
        System.out.println("********************************************");
        System.out.println("               播放列表管理                  ");
        System.out.println("        1--将歌曲添加到主播放列表             ");
        System.out.println("        2--将歌曲添加到普通播放列表           ");
        System.out.println("        3--通过歌曲id查询播放列表中的歌曲     ");
        System.out.println("        4--通过歌曲名称查询播放列表中的歌曲    ");
        System.out.println("        5--修改播放列表中的歌曲               ");
        System.out.println("        6--删除播放列表中的歌曲               ");
        System.out.println("        7--显示播放列表中的所有歌曲            ");
        System.out.println("        9--返回上一级菜单                     ");
        System.out.println("********************************************");
    }

    //播放器菜单
    public void playerMenu()
    {
        System.out.println("********************************************");
        System.out.println("               播放器管理                   ");
        System.out.println("        1--向播放器添加播放列表              ");
        System.out.println("        2--从播放器删除播放列表              ");
        System.out.println("        3--通过名字查询播放列表信息          ");
        System.out.println("        4--显示所有播放列表名称              ");
        System.out.println("        8--导出歌单                          ");
        System.out.println("        9--返回上一级菜单                     ");
        System.out.println("********************************************");
    }


    public void test()
    {
        TestDemo td = new TestDemo();
        Scanner sc = new Scanner(System.in);
        SongExport se = new SongExport();

        //创建一个播放器
        PlayListCollection plc = new PlayListCollection();
        //创建主播放列表
        PlayList mainPlayList = new PlayList("主播放列表");
        //将主播放列表添加到播放器
        plc.addPlayList(mainPlayList);
        PlayList favouritePlayList = null;

        int input = 0;
        int input1 = 0;
        int input2 = 0;
        while (true)
        {
            td.mainMenu();
            System.out.println("请输入对应数字进行操作：");
            input = sc.nextInt();
            if (input == 0)
            {
                break;
            }
            switch (input)
            {
                case 1:
                    //播放列表管理
                    while (true)
                    {
                        td.playListMenu();
                        System.out.println("请输入对应的数字对播放列表进行管理：");
                        input1 = sc.nextInt();
                        if (input1 == 9)
                        {
                            break;
                        }
                        switch (input1)
                        {
                            case 1:
                                System.out.println("将歌曲添加到主播放列表");
                                System.out.println("请输入要添加的歌曲的数量：");
                                int count = sc.nextInt();
                                for (int i = 1; i <= count; i++)
                                {
                                    System.out.println("请输入第" + i + "首歌曲：");
                                    System.out.println("请输入歌曲的id:");
                                    String strId = sc.next();
                                    System.out.println("请输入歌曲的名称：");
                                    String strName = sc.next();
                                    System.out.println("请输入演唱者：");
                                    String strSinger = sc.next();
                                    Song song = new Song(strId,strName,strSinger);
                                    mainPlayList.addToPlayList(song);
                                }
//                                mainPlayList.displayAllSong();
                                break;
                            case 2:
                                System.out.println("将歌曲添加到普通播放列表");
                                System.out.println("请输入要添加的播放列表名称：");
                                String sName = sc.next();
                                //根据名称判断播放列表是否在播放器中存在
                                favouritePlayList = plc.searchPlayListByName(sName);
                                if (favouritePlayList == null)
                                {
                                    System.out.println("该播放列表不存在，请先将播放列表添加到播放器中！");
                                }
                                else
                                {
                                    System.out.println("请输入要添加的歌曲的数量：");
                                    int count1 = sc.nextInt();
                                     for (int i = 1; i <= count1; i++)
                                     {
                                         System.out.println("请输入第" + i + "首歌曲：");
                                         System.out.println("请输入歌曲的id:");
                                         String strId = sc.next();
                                         //首先判断该id的歌曲是否在主播放列表存在
                                         Song song = mainPlayList.searchSongById(strId);
                                         if (song != null)
                                         {
                                             //该歌曲存在于主播放列表，则直接添加到现在的播放列表
                                            favouritePlayList.addToPlayList(song);
                                         }
                                         else
                                         {
                                             System.out.println("该歌曲在主播放列表不存在，继续输入歌曲的其他信息！");
                                             System.out.println("请输入歌曲的名称：");
                                             String strName = sc.next();
                                             System.out.println("请输入演唱者：");
                                             String strSinger = sc.next();
                                             song = new Song(strId,strName,strSinger);
                                             //分别将歌曲添加到普通播放列表和主播放列表
                                             mainPlayList.addToPlayList(song);
                                             favouritePlayList.addToPlayList(song);
                                         }
                                     }
                                     //显示播放列表中的歌曲信息
                                    System.out.println("主播放列表:");
                                    mainPlayList.displayAllSong();
                                    System.out.println("普通播放列表：");
                                    favouritePlayList.displayAllSong();

                                }
                                break;
                            case 3:
                                System.out.println("通过歌曲id查询播放列表中的歌曲");
                                System.out.println("请输入要查询的播放列表名称：");
                                String strPlayListName1 = sc.next();
                                //查询播放列表是否存在
                                PlayList pl = plc.searchPlayListByName(strPlayListName1);
                                if (pl == null)
                                {
                                    System.out.println("该播放列表不存在！");
                                }
                                else
                                {
                                    System.out.println("请输入要查询的歌曲id:");
                                    String strId = sc.next();
                                    Song s = pl.searchSongById(strId);
                                    if (s == null)
                                    {
                                        System.out.println("该歌曲在播放列表" + strPlayListName1 + "中不存在！");
                                    }
                                    else
                                    {
                                        System.out.println("该歌曲的信息为：");
                                        System.out.println(s);
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("通过歌曲名称查询播放列表中的歌曲");
                                System.out.println("请输入要查询的播放列表的名称：");
                                String strPlayListName = sc.next();
                                //查询播放列表是否存在
                                PlayList pl4 = plc.searchPlayListByName(strPlayListName);
                                if (pl4 == null)
                                {
                                    System.out.println("该播放列表不存在！");
                                }
                                else
                                {
                                    System.out.println("请输入要查询的歌曲名称:");
                                    String strName1 = sc.next();
                                    Song s = pl4.searchSongByName(strName1);
                                    if (s == null)
                                    {
                                        System.out.println("该歌曲在播放列表" + strPlayListName + "中不存在！");
                                    }
                                    else
                                    {
                                        System.out.println("该歌曲的信息为：");
                                        System.out.println(s);
                                    }
                                }
                                break;
                            case 5:
                                System.out.println("修改播放列表中的歌曲");
                                System.out.println("请输入要查询的播放列表的名称：");
                                String strPlayListName5 = sc.next();
                                //查询播放列表是否存在
                                PlayList pl5 = plc.searchPlayListByName(strPlayListName5);
                                if (pl5 == null)
                                {
                                    System.out.println("该播放列表不存在！");
                                }
                                else
                                {
                                    System.out.println("请输入要修改的歌曲id:");
                                    String strId = sc.next();
                                    System.out.println("修改为歌曲id:");
                                    String strId2 = sc.next();
                                    System.out.println("修改为歌曲名称：");
                                    String strName = sc.next();
                                    System.out.println("修改为歌曲演唱者：");
                                    String strPlayer = sc.next();
                                    Song song = new Song(strId2,strName,strPlayer);
                                    pl5.updateSong(strId,song);
                                }
                                break;
                            case 6:
                                System.out.println("删除播放列表中的歌曲");
                                System.out.println("请输入要查询的播放列表的名称：");
                                String strPlayListName6 = sc.next();
                                //查询播放列表是否存在
                                PlayList pl6 = plc.searchPlayListByName(strPlayListName6);
                                if (pl6 == null)
                                {
                                    System.out.println("该播放列表不存在！");
                                }
                                else
                                {
                                    System.out.println("请输入要删除的歌曲id:");
                                    String strId = sc.next();
                                    pl6.deleteSong(strId);
                                }
                                break;
                            case 7:
                                System.out.println("显示播放列表中的所有歌曲");
                                Collection<PlayList> playListCollection = plc.getPlayListMap().values();
                                for (PlayList p:playListCollection)
                                {
                                    p.displayAllSong();
                                }
                                break;
                            default: System.out.println("该歌曲没有对应的操作");break;
                        }
                    }
                    break;
                case 2:
                    //播放器管理
                    while (true)
                    {
                        td.playerMenu();
                        System.out.println("请输入对应的数字对播放器进行管理：");
                        input2 = sc.nextInt();
                        if (input2 == 9)
                        {
                            break;
                        }
                        switch (input2)
                        {
                            case 1:
                                System.out.println("向播放器添加播放列表");
                                System.out.println("请输入要添加的播放列表名称：");
                                String playListName = sc.next();
                                //创建一个新的播放列表对象
                                favouritePlayList = new PlayList(playListName);
                                //将播放列表添加到播放器Map
                                plc.addPlayList(favouritePlayList);
                                break;
                            case 2:
                                System.out.println("从播放器删除播放列表");
                                System.out.println("请输入要删除的播放列表的名称：");
                                String strPlayListName = sc.next();
                                if (strPlayListName.equals("主播播放列表"))
                                {
                                    System.out.println("主播放列表不能删除！");
                                    break;
                                }
                                //查询播放列表是否存在
                                PlayList pl = plc.searchPlayListByName(strPlayListName);
                                if (pl == null)
                                {
                                    System.out.println("该播放列表不存在！");
                                }
                                else
                                {
                                    plc.deletePlayList(pl);
                                }
                                break;
                            case 3:
                                System.out.println("通过名字查询播放列表信息");
                                System.out.println("请输入要查询的播放列表的名称：");
                                String strPlayListName3 = sc.next();
                                //查询播放列表是否存在
                                PlayList pl3 = plc.searchPlayListByName(strPlayListName3);
                                if (pl3 == null)
                                {
                                    System.out.println("该播放列表不存在！");
                                }
                                else
                                {
                                    pl3.displayAllSong();
                                }
                                break;
                            case 4:
                                System.out.println("显示所有播放列表名称");
                                plc.displayListName();
                                break;
                            case 8:
                                System.out.println("正在导入歌单中...");
                                Collection<PlayList> playListCollection = plc.getPlayListMap().values();
                                for (PlayList p:playListCollection)
                                {
                                    se.playListExport(p);
                                }
                                try {
                                    se.getBw().close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("导入完成！");
                                break;
                            default: System.out.println("该歌曲没有对应的操作");break;
                        }
                    }
                    break;
                default: System.out.println("该歌曲没有对应的操作");break;
            }
        }
    }

    //测试导入歌曲
    public void testExport()
    {
        Song song1 = new Song("s001","两只老虎","小太阳");
        Song song2 = new Song("s002","小燕子","风车");
        SongExport songExport = new SongExport();
        PlayList mainPlayList = new PlayList("主播放列表");
        mainPlayList.addToPlayList(song1);
        mainPlayList.addToPlayList(song2);
        songExport.playListExport(mainPlayList);
    }


    public static void main(String[] args) {
        TestDemo td = new TestDemo();
//        td.testSong();
//        td.testPlayList();
//        td.testPlayListCollection();
        td.test();
//        td.testExport();
    }
}
