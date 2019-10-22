package io.github.linxiaobaixcg.modules.app.service;

import io.github.linxiaobaixcg.modules.app.entity.VwUser;
import io.github.linxiaobaixcg.modules.app.entity.vo.UserRegisterVo;
import io.github.linxiaobaixcg.modules.app.service.dto.VwUserDTO;
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
