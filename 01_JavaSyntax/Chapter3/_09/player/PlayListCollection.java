package cf.kongjinxing.chap01_03._09.player;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Kong on 2019/12/25.
 */
public class PlayListCollection {
    Map<String, PlayList> playListMap;//存放播放列表集合

    public PlayListCollection()
    {
        playListMap = new HashMap<String, PlayList>();
    }

    /**
     * 向播放器添加播放列表
     * @param playList
     */
    public void addPlayList(PlayList playList)
    {
        //播放列表名称作为key值
        playListMap.put(playList.getPlayListName(),playList);
    }

    /**
     * 删除播放列表
     * @param playList
     */
    public void deletePlayList(PlayList playList)
    {
        playListMap.remove(playList.getPlayListName());
        System.out.println("删除成功！");
    }

    /**
     * 通过播放列表的名称查询播放列表
     * @param playListName
     * @return
     */
    public PlayList searchPlayListByName(String playListName)
    {
        PlayList playList = null;
        Set<String> playlistSet = playListMap.keySet();
        for (String s:playlistSet)
        {
            if (s.equals(playListName))
            {
                playList = playListMap.get(s);break;
            }
        }
        return playList;
    }

    /**
     * 显示播放列表
     */
    public void displayListName()
    {
        Set<String> playListSet = playListMap.keySet();
        System.out.println("播放列表的名称为：");
        for (String s: playListSet)
        {
            System.out.println(s);
        }
    }

    public Map<String, PlayList> getPlayListMap() {
        return playListMap;
    }

    public void setPlayListMap(Map<String, PlayList> playListMap) {
        this.playListMap = playListMap;
    }
}
