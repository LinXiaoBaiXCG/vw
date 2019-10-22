package io.github.linxiaobaixcg.modules.app.controller;

import cn.hutool.core.lang.UUID;
import com.qiniu.util.Base64;
import com.qiniu.util.UrlSafeBase64;
import io.github.linxiaobaixcg.common.util.QiniuCloudUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: vw
 * @description: 七牛云接口
 * @author: LCQ
 * @create: 2019-10-22 20:53
 **/
@RestController
@RequestMapping("/api/qiniuyun")
@Slf4j
public class QiniuyunController {

    @PostMapping("/upload")
    @ApiOperation("长传文件")
    public ResponseEntity upload(@RequestParam MultipartFile file, HttpServletRequest request) {
        String url = null;
        try {
        byte[] bytes = file.getBytes();
        String imageName = UUID.randomUUID().toString();
        QiniuCloudUtil qiniuUtil = new QiniuCloudUtil();
        try {
            //使用base64方式上传到七牛云
            url = qiniuUtil.put64image(bytes, imageName);
        }catch (Exception e) {
            log.error("上传图片错误:{}",e.getMessage());
        }
        }catch (IOException e){
            log.error("上传图片转换错误:{}",e.getMessage());
        }
        return ResponseEntity.ok(url);
    }
}
