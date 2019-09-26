package io.github.linxiaobaixcg.modules.app.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.modules.app.entity.VwProblem;
import io.github.linxiaobaixcg.modules.app.oauth2.annotation.Login;
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

    @Login
    @ApiOperation("创建问题")
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody @Validated VwProblem vwProblem, @RequestAttribute("userId") Long userId) {
        vwProblem.setUserId(userId);
        return new ResponseEntity(vwProblemService.addProblem(vwProblem), HttpStatus.CREATED);
    }

    @Login
    @ApiOperation("我的提问列表")
    @GetMapping("/userProblem")
    public ResponseEntity userProblem(Page page, @RequestAttribute("userId") Long userId) {
        return new ResponseEntity(vwProblemService.getUserProblem(page, userId), HttpStatus.OK);
    }

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
