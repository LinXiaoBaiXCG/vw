package io.github.linxiaobaixcg.modules.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.common.exception.CustomException;
import io.github.linxiaobaixcg.common.util.ValidatorUtils;
import io.github.linxiaobaixcg.modules.app.entity.VwAnswer;
import io.github.linxiaobaixcg.modules.app.entity.VwFollow;
import io.github.linxiaobaixcg.modules.app.service.VwFollowService;
import io.github.linxiaobaixcg.modules.system.controller.vo.ResultVO;
import io.github.linxiaobaixcg.modules.app.entity.vo.VwFollowVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: app
 * @description:VwFollowController
 * @author: LCQ
 * @create: 2019-05-20 21:50
 **/
@RestController
@RequestMapping("/app/vw/follow")
@Api(tags = "关注操作相关接口")
@Slf4j
public class VwFollowController {

    @Autowired
    VwFollowService vwFollowService;

    @ApiOperation("添加关注")
    @PostMapping("/sava")
    public ResultVO sava(@RequestBody VwFollowVO vwFollowVO){
        return new ResultVO();
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
