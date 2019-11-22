package io.github.linxiaobaixcg.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @program: vw
 * @description: 七牛云接口
 * @author: LCQ
 * @create: 2019-10-22 20:53
 **/
public interface QiniuyunService {

    /**
     * 文件上传
     * @param file
     */
    void upload(MultipartFile file);

}
