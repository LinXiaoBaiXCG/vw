/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.lcq.app.common.exception;

import com.lcq.app.modules.system.controller.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 异常处理器
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(CustomException.class)
	public ResultVO handleCustomException(CustomException e){
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(e.getCode());
		resultVO.setMsg(e.getMsg());
		return resultVO;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResultVO handlerNoFoundException(Exception e) {
		log.error(e.getMessage(), e);
		return new ResultVO(404, "路径不存在，请检查路径是否正确");
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public ResultVO handleDuplicateKeyException(DuplicateKeyException e){
		log.error(e.getMessage(), e);
		return new ResultVO("数据库中已存在该记录");
	}

//	@ExceptionHandler(AuthorizationException.class)
//	public ResultVO handleAuthorizationException(AuthorizationException e){
//		logger.error(e.getMessage(), e);
//		return R.error("没有权限，请联系管理员授权");
//	}

//	@ExceptionHandler(Exception.class)
//	public ResultVO handleException(Exception e){
//		log.error(e.getMessage(), e);
//		return new ResultVO(500,"未知异常，请联系管理员");
//	}
}
