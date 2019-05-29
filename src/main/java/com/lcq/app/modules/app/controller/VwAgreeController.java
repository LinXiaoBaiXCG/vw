package com.lcq.app.modules.app.controller;

import com.lcq.app.modules.app.service.VwAgreeService;
import com.lcq.app.modules.app.service.VwAnswerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @program: app
 * @description:VwAnswerController
 * @author: LCQ
 * @create: 2019-05-20 21:50
 **/
@RestController
@RequestMapping("/app/vw/agree")
@Slf4j
public class VwAgreeController {
    private final VwAgreeService vwAgreeService;

    public VwAgreeController( VwAgreeService vwAgreeService) {
        this.vwAgreeService = vwAgreeService;
    }



}
