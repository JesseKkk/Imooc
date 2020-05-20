package cf.kongjinxing.chap01_03._09.player;


import java.io.*;

/**
 * Created by Kong on 2019/12/25.
 */
public class SongExport {
    private BufferedWriter bw;

    public BufferedWriter getBw() {
        return bw;
    }

    public void setBw(BufferedWriter bw) {
        this.bw = bw;
    }

    public SongExport()
    {
        try {
            bw = new BufferedWriter(new OutputStreamWriter
                    (new FileOutputStream("Songs.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public void playListExport(PlayList playList)
    {
        try {
            bw.write(playList.getPlayListName() + ":");
            bw.newLine();
            for (Song s:playList.getMusicList())
            {
                songExprot(s);
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void songExprot(Song song)
    {

        try {
            bw.write(song.toString());
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
