package cn.zdh.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {

    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static Random r = new Random();
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    /**
     * 将CommonsMultipartFile转换成File
     * @param cFile
     * @return
     */
    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile){

        File newFile = new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);
        }catch (Exception e){
            logger.error(e.toString());
        }
        return newFile;

    }

    /**
     * 处理缩略图， 并返回新生成图片的相对值路径
     *
     * @param targetAddr
     * @return
     */

    public static String generateThumbnail(InputStream thumbnailInputStream, String targetAddr, String fileName){
        String realFileName = getRandomFileName();
        String extension = getFileExtension(fileName);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        logger.debug("current relativeAddr is " + relativeAddr);
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        logger.debug("current complete addr is " + PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnailInputStream).size(200,200).
                    watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/ship.bmp")),
                            0.25f).outputQuality(0.8f).toFile(dest);
        }catch (Exception e){
            logger.error(e.toString());
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * 创建目标路径所涉及到的目录，即/home/o2o_Img/xxx.jpg
     * 那么home  o2o_Img都要自动创建
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {

        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()){
            dirPath.mkdirs();
        }

    }

    /**
     * 获取输入文件流的扩展名
     *
     * @return
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }


    /**
     * 生成随机文件名，当前年月日小时分钟秒+五位随机数
     * @return
     */

    public static String getRandomFileName(){

        //获取随机五位数
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());

        return nowTimeStr + rannum;
    }

    /**
     * storePath是文件路径还是目录路径
     * 如果storePath是文件路径则删除改文件
     * 如果storePath是目录路径则删除该目录下的所有文件
     *
     * @param storePath
     */
    public static void deleteFileOrPath(String storePath){

        File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
        if (fileOrPath.exists()){
            if (fileOrPath.isDirectory()){
                File file[] = fileOrPath.listFiles();
                for(int i = 0; i < file.length; i++){
                    file[i].delete();
                }
            }
            fileOrPath.delete();
        }
    }
}
