package cn.scholar.common.utils;

import cn.scholar.common.constant.MyConstant;
import cn.scholar.common.message.enums.CommonEnum;
import cn.scholar.common.message.enums.CourseEnum;
import cn.scholar.common.message.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Slf4j
public class MyFileUtil {

    /**
     * 图片上传
     * @param file
     * @return
     */
    public static String uploadImage(MultipartFile file) {
        String fileName = null;
        if(file.isEmpty() || file == null) {//如果文件为
              throw new CommonException(CommonEnum.FILE_IS_NULL);
        }else {
            try {
                fileName = file.getOriginalFilename();  // 文件名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
                String filePath = MyConstant.IMAGE_PATH;
                fileName = UUID.randomUUID() + suffixName; // 新文件名
                File dest = new File(filePath + fileName);//文件对象
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                file.transferTo(dest);//复制保存到服务器

            } catch (Exception e) {
                e.printStackTrace();
                throw new CommonException(CourseEnum.COURSE_UPDATE_FAIL);
            }
        }
        return fileName;
    }

    /**
     * 删除文件
     * @param path
     */
    public static void dropFile(String path){
       File file = new File(path);
       if(file.exists()){//如果文件存在
           log.info("========>delete file {} in {}",file.getName(),file.getAbsolutePath());
           file.delete();//删除
       }
    }



}
