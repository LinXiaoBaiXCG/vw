package com.lcq.app.modules.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcq.app.common.exception.CustomException;
import com.lcq.app.modules.app.controller.vo.VwAgreeVO;
import com.lcq.app.modules.app.entity.VwAgree;
import com.lcq.app.modules.app.service.VwAgreeService;
import com.lcq.app.modules.system.controller.vo.ResultVO;
import com.lcq.app.utils.ValidatorUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @program: app
 * @description:VwFollowController
 * @author: LCQ
 * @create: 2019-05-20 21:50
 **/
@RestController
@RequestMapping("/app/vw/follow")
@Slf4j
public class VwFollowController {


}
