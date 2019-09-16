package io.github.linxiaobaixcg.modules.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.common.exception.CustomException;
import io.github.linxiaobaixcg.common.util.ValidatorUtils;
import io.github.linxiaobaixcg.modules.system.controller.vo.ResultVO;
import io.github.linxiaobaixcg.modules.app.controller.vo.VwAnswerSavaVO;
import io.github.linxiaobaixcg.modules.app.entity.VwAnswer;
import io.github.linxiaobaixcg.modules.app.service.VwAnswerService;
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
@RequestMapping("/app/vw/answer")
@Api(tags = "回答操作相关接口")
@Slf4j
public class VwAnswerController {
    private final VwAnswerService vwAnswerService;

    public VwAnswerController(VwAnswerService vwAnswerService) {
        this.vwAnswerService = vwAnswerService;
    }

    @ApiOperation("新增回答")
    @PostMapping("/sava")
    public ResultVO sava(@RequestBody VwAnswerSavaVO vwAnswerSavaVO) {
        //VO校验
        ValidatorUtils.validateEntity(vwAnswerSavaVO);
        ResultVO resultVO = new ResultVO();
        VwAnswer vwAnswer = new VwAnswer();
        BeanUtils.copyProperties(vwAnswerSavaVO, vwAnswer);
        vwAnswer.setIsDelete(1);
        vwAnswer.setIsRecommend(2);
        Boolean flag = vwAnswerService.save(vwAnswer);
        if (flag) {
            resultVO.setCode(0);
            resultVO.setMsg("添加回答成功");
        } else{
            throw new CustomException("添加回答失败");
        }
        return resultVO;
    }

    @ApiOperation("首页--获取推荐回答列表")
    @GetMapping("/recommend/page")
    public ResultVO recommendPage(@RequestParam int current, @RequestParam int size) {
        ResultVO resultVO = new ResultVO();
        Page<VwAnswer> page = new Page<>(current, size);
        QueryWrapper<VwAnswer> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        queryWrapper.eq("is_recommend", 1);
        try {
            IPage<VwAnswer> iPage = vwAnswerService.page(page, queryWrapper);
            resultVO.setCode(0);
            resultVO.setMsg("获取推荐回答列表成功");
            resultVO.setData(iPage);
        } catch (Exception e) {
            log.error("获取推荐回答列表失败",e);
            throw new CustomException("获取推荐回答列表失败");
        }
        return resultVO;
    }

    @ApiOperation("获取回答详细内容")
    @GetMapping("/details/{id}")
    public ResultVO details(@PathVariable String id){
        ResultVO resultVO = new ResultVO();
        try {
            VwAnswer vwAnswer = vwAnswerService.getById(id);
            resultVO.setCode(0);
            resultVO.setMsg("获取回答详细内容成功");
            resultVO.setData(vwAnswer);
        } catch (Exception e) {
            log.error("获取回答详细内容失败",e);
            throw new CustomException("获取回答详细内容失败");
        }
        return resultVO;
    }
}
