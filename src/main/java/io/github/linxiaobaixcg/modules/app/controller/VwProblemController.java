package io.github.linxiaobaixcg.modules.app.controller;

import io.github.linxiaobaixcg.modules.app.entity.VwProblem;
import io.github.linxiaobaixcg.modules.app.service.VwProblemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @program: app
 * @description:VwProblemController
 * @author: LCQ
 * @create: 2019-05-20 21:50
 **/
@RestController
@RequestMapping("/api/problem")
@Api(tags = "问题操作相关接口")
@Slf4j
public class VwProblemController {

    @Autowired
    private VwProblemService vwProblemService;


    @ApiOperation("创建问题")
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody @Validated VwProblem vwProblem) {
        return new ResponseEntity(vwProblemService.addProblem(vwProblem), HttpStatus.CREATED);
    }

//    @ApiOperation("我的提问列表")
//    @GetMapping("problem/page")
//    public ResultVO problemList(@RequestParam String userId, @RequestParam int current, @RequestParam int size) {
//        ResultVO resultVO = new ResultVO();
//        Page<VwProblem> page = new Page<>(current, size);
//        QueryWrapper<VwProblem> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByDesc("create_time");
//        queryWrapper.eq("user_id", userId);
//        try {
//            IPage<VwProblem> IPage = vwProblemService.page(page, queryWrapper);
//            log.info("用户{}获取提问列表成功",userId);
//            resultVO.setCode(0);
//            resultVO.setMsg("查询成功");
//            resultVO.setData(IPage);
//        }catch (Exception e){
//            log.error("用户ID为{}的获取提问列表失败",userId,e);
//            throw new CustomException("查询失败");
//        }
//        return resultVO;
//    }
//
//    @ApiOperation("首页--问题搜索")
//    @GetMapping("search")
//    public ResultVO search(@RequestParam @Validated String title, @RequestParam(defaultValue = "0",required = false) int current, @RequestParam(defaultValue = "10",required = false) int size){
//        ResultVO resultVO = new ResultVO();
//        Page<VwProblem> page = new Page<>(current, size);
//        try {
//           IPage<VwProblem> vwProblemIPage = vwProblemService.getListByTitle(page,title);
//           resultVO.setCode(0);
//           resultVO.setMsg("搜索成功");
//           resultVO.setData(vwProblemIPage);
//        }catch (Exception e){
//            log.error("搜索问题失败",e);
//            throw new CustomException("搜索出现错误");
//        }
//
//        return resultVO;
//    }
}
