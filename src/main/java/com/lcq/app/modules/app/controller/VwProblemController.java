package com.lcq.app.modules.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcq.app.common.exception.CustomException;
import com.lcq.app.modules.app.controller.vo.VwProblemVO;
import com.lcq.app.modules.app.entity.VwProblem;
import com.lcq.app.modules.app.service.VwProblemService;
import com.lcq.app.modules.system.controller.vo.ResultVO;
import com.lcq.app.common.util.ValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @program: app
 * @description:VwProblemController
 * @author: LCQ
 * @create: 2019-05-20 21:50
 **/
@RestController
@RequestMapping("/app/vw/problem")
@Api(description = "问题操作相关接口")
@Slf4j
public class VwProblemController {

    private final VwProblemService vwProblemService;

    public VwProblemController(VwProblemService vwProblemService) {
        this.vwProblemService = vwProblemService;
    }

    @ApiOperation("创建问题")
    @PostMapping("create")
    public ResultVO create(@RequestBody VwProblemVO vwProblemVO) throws Exception {
        //VO校验
        ValidatorUtils.validateEntity(vwProblemVO);
        ResultVO resultVO = new ResultVO();
        VwProblem vwProblem = new VwProblem();
        vwProblem.setUserId(vwProblemVO.getUserId());
        vwProblem.setTitle(vwProblemVO.getTitle());
        vwProblem.setVwDescribe(vwProblemVO.getVwDescribe());
        vwProblem.setStatus(1);
        Boolean result = vwProblemService.save(vwProblem);
        if (result) {
            resultVO.setCode(0);
            resultVO.setMsg("添加成功");
        } else {
            throw new CustomException("添加失败");
        }
        return resultVO;
    }

    @ApiOperation("我的提问列表")
    @GetMapping("problem/page")
    public ResultVO problemList(@RequestParam String userId, @RequestParam int current, @RequestParam int size) {
        ResultVO resultVO = new ResultVO();
        Page<VwProblem> page = new Page<>(current, size);
        QueryWrapper<VwProblem> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        queryWrapper.eq("user_id", userId);
        try {
            IPage<VwProblem> IPage = vwProblemService.page(page, queryWrapper);
            log.info("用户{}获取提问列表成功",userId);
            resultVO.setCode(0);
            resultVO.setMsg("查询成功");
            resultVO.setData(IPage);
        }catch (Exception e){
            log.error("用户ID为{}的获取提问列表失败",userId,e);
            throw new CustomException("查询失败");
        }
        return resultVO;
    }

    @ApiOperation("首页--问题搜索")
    @GetMapping("search")
    public ResultVO search(@RequestParam @Validated String title, @RequestParam(defaultValue = "0",required = false) int current, @RequestParam(defaultValue = "10",required = false) int size){
        ResultVO resultVO = new ResultVO();
        Page<VwProblem> page = new Page<>(current, size);
        try {
           IPage<VwProblem> vwProblemIPage = vwProblemService.getListByTitle(page,title);
           resultVO.setCode(0);
           resultVO.setMsg("搜索成功");
           resultVO.setData(vwProblemIPage);
        }catch (Exception e){
            log.error("搜索问题失败",e);
            throw new CustomException("搜索出现错误");
        }

        return resultVO;
    }
}
