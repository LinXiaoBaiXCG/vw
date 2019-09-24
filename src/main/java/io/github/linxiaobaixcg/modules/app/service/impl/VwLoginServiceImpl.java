package io.github.linxiaobaixcg.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.linxiaobaixcg.common.exception.BadRequestException;
import io.github.linxiaobaixcg.common.util.EncryptUtils;
import io.github.linxiaobaixcg.common.util.JwtUtils;
import io.github.linxiaobaixcg.modules.app.oauth2.AuthenticationInfo;
import io.github.linxiaobaixcg.modules.app.entity.vo.LoginVo;
import io.github.linxiaobaixcg.modules.app.entity.VwUser;
import io.github.linxiaobaixcg.modules.app.repository.VwUserRepository;
import io.github.linxiaobaixcg.modules.app.service.VwLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author linchuangqiong
 * @date 2019/9/16
 * @Description
 */
@Service
public class VwLoginServiceImpl implements VwLoginService {

    @Autowired
    private VwUserRepository vwUserRepository;

    @Override
    public AuthenticationInfo login(LoginVo loginVo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("phone", loginVo.getPhone());
        VwUser vwUser = vwUserRepository.selectOne(queryWrapper);
        if (vwUser == null) {
            throw new BadRequestException("该用户不存在！");
        }
        if (vwUser != null && vwUser.getStatus() == 1) {
            throw new BadRequestException("该用户已被锁定！");
        }
        if (!vwUser.getPassword().equals(EncryptUtils.encryptPassword(loginVo.getPassword()))) {
            throw new BadRequestException("密码错误，请重新输入");
        }
        //返回token和用户信息
        return new AuthenticationInfo(JwtUtils.sign(vwUser.getUsername(),vwUser.getPassword()),vwUser);
    }
}
