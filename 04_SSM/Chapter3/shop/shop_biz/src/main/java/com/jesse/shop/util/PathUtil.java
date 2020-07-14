package com.jesse.shop.util;

/**
 * Created by Kong on 2020/6/23.
 */
public class PathUtil {
    private static String seperator = System.getProperty("file.separator");

    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath= "";
        if (os.toLowerCase().startsWith("win")){
            basePath = "G:/img";
        } else {
            basePath = "/home/kong/img";
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }

    public static String getStoreImagePath(long storeId) {
        String imagePath = "/upload/item/store/" + storeId + "/";
        return imagePath.replace("/", seperator);
    }
}