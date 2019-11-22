package io.github.linxiaobaixcg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.linxiaobaixcg.exception.BadRequestException;
import io.github.linxiaobaixcg.entity.VwUser;
import io.github.linxiaobaixcg.entity.vo.LoginVo;
import io.github.linxiaobaixcg.oauth2.utils.EncryptUtil;
import io.github.linxiaobaixcg.oauth2.utils.JwtUtil;
import io.github.linxiaobaixcg.repository.VwUserRepository;
import io.github.linxiaobaixcg.service.VwLoginService;
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

    @Autowired
    private JwtUtil jwtUtils;

    @Override
    public String login(LoginVo loginVo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("phone", loginVo.getPhone());
        VwUser vwUser = vwUserRepository.selectOne(queryWrapper);
        if (vwUser == null) {
            throw new BadRequestException("该用户不存在！");
        }
        if (vwUser != null && vwUser.getStatus() == 1) {
            throw new BadRequestException("该用户已被锁定！");
        }
        if (!vwUser.getPassword().equals(EncryptUtil.encryptPassword(loginVo.getPassword()))) {
            throw new BadRequestException("密码错误，请重新输入");
        }
        //返回token
        return jwtUtils.generateToken(vwUser.getId());
    }
}
