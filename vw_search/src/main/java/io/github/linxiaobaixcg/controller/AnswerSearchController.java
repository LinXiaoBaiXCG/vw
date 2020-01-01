package io.github.linxiaobaixcg.controller;

import io.github.linxiaobaixcg.entity.Result;
import io.github.linxiaobaixcg.entity.StatusCode;
import io.github.linxiaobaixcg.service.AnswerSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: vw
 * @description:
 * @author: LCQ
 * @create: 2020-01-01 13:48
 **/
@RestController
@RequestMapping("/api/search")
public class AnswerSearchController {

    @Autowired
    private AnswerSearchService answerSearchService;

    @GetMapping
    public Result search(@RequestParam String keywords, @RequestParam Pageable  pageable){
        return new Result(StatusCode.OK,answerSearchService.findByTitleLike(keywords,pageable));
    }
}
