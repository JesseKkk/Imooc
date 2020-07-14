package com.jesse.shop.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kong on 2020/6/23.
 */
@Configuration
public class PathUtil {
    private static String seperator = System.getProperty("file.separator");

    private static String winPath;

    private static String linuxPath;

    private static String storePath;

    @Value("${win.base.path}")
    public void setWinPath(String winPath) {
        PathUtil.winPath = winPath;
    }

    @Value("${linux.base.path}")
    public void setLinuxPath(String linuxPath) {
        PathUtil.linuxPath = linuxPath;
    }

    @Value("${store.relevant.path}")
    public void setStorePath(String storePath) {
        PathUtil.storePath = storePath;
    }

    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath= "";
        if (os.toLowerCase().startsWith("win")){
            basePath = winPath;
        } else {
            basePath = linuxPath;
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }

    public static String getStoreImagePath(long storeId) {
        String imagePath = storePath + storeId + seperator;
        return imagePath.replace("/", seperator);
    }
}