package org.wjf.springcloudhystrixprovide01.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wjf.springcloud.api.Service;
import org.wjf.springcloud.entity.Info;
import org.wjf.springcloud.vo.ResultTemplate;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/test")
public class TestController {

	private static Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private Service service;

	@GetMapping("/getInfoById/{id}")
	public ResultTemplate<Info> getInfoById(@PathVariable("id") Integer id) {
		return ResultTemplate.getSuccessResult(service.findInfoById(id));
	}

	@GetMapping("/getTimeOutInfoById/{id}")
	public ResultTemplate<Info> getTimeOutInfoById(@PathVariable("id") Integer id) {
		logger.info("***进来了一个新请求");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ResultTemplate.getSuccessResult(service.findInfoById(id));
	}

}
