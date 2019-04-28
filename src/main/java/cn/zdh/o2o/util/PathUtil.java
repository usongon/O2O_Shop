package cn.zdh.o2o.util;

public class PathUtil {
    private static String seperator = System.getProperty("file.separator");
    public static String getImgBasePath(){

        String  os = System.getProperty("os.name");

        String basePath = "";
        if (os.toLowerCase().startsWith("win")){
            basePath="D:/O2O_Img/";
        }else {
            basePath = "/home/o2o_Img/";
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }

    public static String getShopImagePath(Long shopId){
        String imagePath = "upload/item/shop/" + shopId + "/";
        return imagePath.replace("/", seperator);
    }
}
