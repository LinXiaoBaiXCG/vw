package com.lcq.app.modules.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lcq.app.exception.CustomException;
import com.lcq.app.modules.app.controller.vo.VwProblemVO;
import com.lcq.app.modules.app.entity.VwProblem;
import com.lcq.app.modules.app.service.VwProblemService;
import com.lcq.app.modules.system.controller.vo.ResultVO;
import com.lcq.app.utils.ValidatorUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @program: app
 * @description:VwProblemController
 * @author: LCQ
 * @create: 2019-05-20 21:50
 **/
@RestController
@RequestMapping("/app/vw/problem")
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
    @GetMapping("problemList")
    public IPage problemList(@RequestParam int current,@RequestParam int size) {

        Page<VwProblem> page = new Page<>(current,size);
        QueryWrapper<VwProblem> queryWrapper =  new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.eq("user_id","1");
        return vwProblemService.getBaseMapper().selectPage(page,queryWrapper);
    }
}
