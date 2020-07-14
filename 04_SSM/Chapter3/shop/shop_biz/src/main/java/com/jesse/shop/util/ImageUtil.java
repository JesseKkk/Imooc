package com.jesse.shop.util;

import com.jesse.shop.dto.ImageHolder;
import com.jesse.shop.exceptions.StoreOperationException;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Kong on 2020/6/23.
 */
public class ImageUtil {
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    /**
     * 处理缩略图，并返回新生成图片的相对值路径
     * @param thumbnail
     * @param targetAddr
     * @return
     */
    public static String generateThumbnail(ImageHolder thumbnail, String targetAddr) {
        String realFileName = getRandomFileName();
        String extension = gerFileExtension(thumbnail.getImageName());
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        logger.debug("current relativeAddr is: " + relativeAddr );
        File dest = new File(PathUtil.getImgBasePath()+ relativeAddr);
        logger.debug("current complete addr is: " + PathUtil.getImgBasePath() + relativeAddr);
        try{
            Thumbnails.of(thumbnail.getImage()).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT,
                     ImageIO.read(new File(basePath + "watermark.jpg")), 0.25f).outputQuality(0.8f)
                    .toFile(dest);
        } catch (IOException e) {
            logger.error(e.toString());
            throw new StoreOperationException("创建缩略图失败：" + e.toString());
        }
        return relativeAddr;
    }

    public static String generateNormalImg(ImageHolder thumbnail, String targetAddr) {
        String realFileName = getRandomFileName();
        String extension = gerFileExtension(thumbnail.getImageName());
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        logger.debug("current relativeAddr is: " + relativeAddr );
        File dest = new File(PathUtil.getImgBasePath()+ relativeAddr);
        logger.debug("current complete addr is: " + PathUtil.getImgBasePath() + relativeAddr);
        try{
            Thumbnails.of(thumbnail.getImage()).size(337, 640)
                    .watermark(Positions.BOTTOM_RIGHT,
                            ImageIO.read(new File(basePath + "watermark.jpg")), 0.25f).outputQuality(0.9f)
                    .toFile(dest);
        } catch (IOException e) {
            logger.error(e.toString());
            throw new StoreOperationException("创建缩略图失败：" + e.toString());
        }
        return relativeAddr;
    }

    //创建目标路径所涉及的目录，及/home/work/kong/xxx.jpg,
    //那么home work kong 这三个文件夹都得自动创建
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    //获得输入文件流的扩展名
    private static String gerFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    //生成随机文件名，当前年月日小时分钟秒钟+五位随机数
    private static String getRandomFileName() {
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }

    /**
     * storePath是文件的路径还是目录的路径，
     * 如果storePath是文件路径则删除该文件
     * 如果storePath是目录路径则删除该目录下的所有文件
     * @param storePath
     */
    public static void deleteFileOrPath(String storePath) {
        File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
        if (fileOrPath.exists()){
            if (fileOrPath.isDirectory()) {
                File files[] = fileOrPath.listFiles();
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }
    }


    public static void main(String[] args) throws IOException {
        System.out.println(basePath);
        Thumbnails.of(new File("G:\\img\\kong.jpg"))
                .size(200, 200).watermark(Positions.BOTTOM_RIGHT,
                ImageIO.read(new File(basePath + "watermark.jpg")), 0.25f).outputQuality(0.8f)
                .toFile("G:\\img\\kongnew.jpg");
    }
}
