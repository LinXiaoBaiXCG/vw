package io.github.linxiaobaixcg.modules.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.linxiaobaixcg.common.exception.CustomException;
import io.github.linxiaobaixcg.common.util.ValidatorUtils;
import io.github.linxiaobaixcg.modules.app.service.dto.VwAnswerQueryCriteria;
import io.github.linxiaobaixcg.modules.system.controller.vo.ResultVO;
import io.github.linxiaobaixcg.modules.app.entity.vo.VwAnswerSavaVO;
import io.github.linxiaobaixcg.modules.app.entity.VwAnswer;
import io.github.linxiaobaixcg.modules.app.service.VwAnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @program: app
 * @description:VwAnswerController
 * @author: LCQ
 * @create: 2019-05-20 21:50
 **/
@RestController
@RequestMapping("/api/answer")
@Api(tags = "回答操作相关接口")
@Slf4j
public class VwAnswerController {

    @Autowired
    private VwAnswerService vwAnswerService;

    @ApiOperation("新增回答")
    @PostMapping("/insert")
    public ResponseEntity insert(@RequestBody VwAnswer vwAnswer) {
        return new ResponseEntity(vwAnswerService.insert(vwAnswer), HttpStatus.CREATED);
    }

    @ApiOperation("首页--获取回答列表")
    @GetMapping("/recommend/page")
    public ResponseEntity recommendPage(Page page, VwAnswerQueryCriteria queryCriteria) {
        return new ResponseEntity(vwAnswerService.getPage(page, queryCriteria), HttpStatus.OK);
    }

    @ApiOperation("获取回答详细")
    @GetMapping("/details/{id}")
    public ResponseEntity details(@PathVariable Long id) {
        return new ResponseEntity(vwAnswerService.findOne(id), HttpStatus.OK);
    }

    @ApiOperation("同意回答")
    @GetMapping("/agree")
    public ResponseEntity agree(@RequestParam String uuid, @RequestParam Integer type, @RequestParam Long userId) {
        vwAnswerService.agree(uuid, type, userId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
