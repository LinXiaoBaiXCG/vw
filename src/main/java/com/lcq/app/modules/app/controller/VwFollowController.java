package com.lcq.app.modules.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcq.app.common.exception.CustomException;
import com.lcq.app.modules.app.controller.vo.VwFollowVO;
import com.lcq.app.modules.app.entity.VwAnswer;
import com.lcq.app.modules.app.entity.VwFollow;
import com.lcq.app.modules.app.service.VwFollowService;
import com.lcq.app.modules.system.controller.vo.ResultVO;
import com.lcq.app.common.util.ValidatorUtils;
import io.swagger.annotations.Api;
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
@Api(description = "关注操作相关接口")
@Slf4j
public class VwFollowController {
    private final VwFollowService vwFollowService;

    public VwFollowController(VwFollowService vwFollowService) {
        this.vwFollowService = vwFollowService;
    }

    @ApiOperation("添加关注")
    @PostMapping("/sava")
    public ResultVO sava(@RequestBody VwFollowVO vwFollowVO){
        ValidatorUtils.validateEntity(vwFollowVO);
        ResultVO resultVO = new ResultVO();
        QueryWrapper<VwFollow> vwFollowWrapper = new QueryWrapper<>();
        vwFollowWrapper.eq("user_id",vwFollowVO.getUserId());
        vwFollowWrapper.eq("concerned_id",vwFollowVO.getConcernedId());
        try{
        VwFollow result = vwFollowService.getOne(vwFollowWrapper);
        if (result == null){
        VwFollow vwFollow = new VwFollow();
        BeanUtils.copyProperties(vwFollowVO,vwFollow);
        Boolean flag = vwFollowService.save(vwFollow);
        if (flag){
            resultVO.setCode(0);
            resultVO.setMsg("添加关注成功");
        }else {
            throw new CustomException("添加关注失败");
        }
        }else {
            Boolean flag = vwFollowService.remove(vwFollowWrapper);
            if (flag){
                resultVO.setCode(0);
                resultVO.setMsg("取消关注成功");
            }else {
                throw new CustomException("取消关注失败");
            }
        }
        }catch (Exception e){
            log.error("添加关注有误",e);
            throw new CustomException("添加关注有误");
        }
        return resultVO;
    }

    @ApiOperation("我的关注列表")
    @GetMapping("/page")
    public ResultVO page(@RequestParam String userId, @RequestParam int current, @RequestParam int size){
        ResultVO resultVO = new ResultVO();
        Page<VwFollow> page = new Page<>(current,size);
        try {
        IPage<VwFollow> vwFollowIPage = vwFollowService.getPageByUserId(page,userId);
        resultVO.setCode(0);
        resultVO.setMsg("获取我的关注列表成功");
        resultVO.setData(vwFollowIPage);
        }catch (Exception e){
        log.error("用户ID为{}的获取关注列表失败",userId,e);
        throw new CustomException("获取我的关注列表失败");
    }
        return resultVO;
    }

    @ApiOperation("首页--关注的人原创文章列表")
    @GetMapping("/answer/page")
    public ResultVO answerPage(@RequestParam String userId, @RequestParam int current, @RequestParam int size){
        ResultVO resultVO = new ResultVO();
        Page<VwFollow> page = new Page<>(current,size);
        try {
            IPage<VwAnswer> answerIPage = vwFollowService.answerPage(page,userId);
            resultVO.setCode(0);
            resultVO.setMsg("获取我关注的人原创文章列表成功");
            resultVO.setData(answerIPage);
        }catch (Exception e){
            log.error("用户ID为{}的获取原创文章列表失败",userId,e);
            throw new CustomException("获取我关注的人原创文章列表失败");
        }
        return resultVO;
    }
}
