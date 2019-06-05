package com.lcq.app.modules.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcq.app.common.exception.CustomException;
import com.lcq.app.modules.app.controller.vo.VwAgreeVO;
import com.lcq.app.modules.app.entity.VwAgree;
import com.lcq.app.modules.app.entity.VwProblem;
import com.lcq.app.modules.app.service.VwAgreeService;
import com.lcq.app.modules.app.service.VwAnswerService;
import com.lcq.app.modules.system.controller.vo.ResultVO;
import com.lcq.app.utils.ValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @program: app
 * @description:VwAnswerController
 * @author: LCQ
 * @create: 2019-05-20 21:50
 **/
@RestController
@RequestMapping("/app/vw/agree")
@Api(description = "点赞操作相关接口")
@Slf4j
public class VwAgreeController {
    private final VwAgreeService vwAgreeService;

    public VwAgreeController( VwAgreeService vwAgreeService) {
        this.vwAgreeService = vwAgreeService;
    }

    @ApiOperation("点赞回答")
    @PostMapping("agreeAnswer")
    public ResultVO agreeAnswer(@RequestBody VwAgreeVO vwAgreeVO){
        //VO校验
        ValidatorUtils.validateEntity(vwAgreeVO);
        ResultVO resultVO = new ResultVO();
        VwAgree vwAgree = new VwAgree();
        BeanUtils.copyProperties(vwAgreeVO,vwAgree);
        Boolean flag = vwAgreeService.save(vwAgree);
        if (flag){
            resultVO.setCode(0);
            resultVO.setMsg("点赞成功");
        }else
            throw new CustomException("点赞失败，请重试");
        return resultVO;
    }

    @ApiOperation("我的点赞列表")
    @GetMapping("agree/page")
    public ResultVO agreeList(@RequestParam String userId, @RequestParam int current, @RequestParam int size) {
        ResultVO resultVO = new ResultVO();
        Page<VwAgree> page = new Page<>(current, size);
        QueryWrapper<VwAgree> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        queryWrapper.eq("user_id", userId);
        try {
            IPage<VwAgree> IPage = vwAgreeService.page(page, queryWrapper);
            resultVO.setCode(0);
            resultVO.setMsg("查询成功");
            resultVO.setData(IPage);
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomException("查询失败");
        }
        return resultVO;
    }
}
