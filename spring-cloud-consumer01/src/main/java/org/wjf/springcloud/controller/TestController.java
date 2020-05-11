package org.wjf.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wjf.springcloud.api.Service;
import org.wjf.springcloud.entity.Info;
import org.wjf.springcloud.vo.ResultTemplate;

@Controller
@ResponseBody
public class TestController {

	@Autowired
	private Service service;

	@PostMapping("/createNewInfo")
	public ResultTemplate<Info> createNewInfo(Info info) {
		return service.createNewInfo(info) > 0 ? ResultTemplate.getSuccessResult() : ResultTemplate.getFailResult();
	}

	@GetMapping("/findInfoById/{id}")
	public ResultTemplate<Info> findInfoById(@PathVariable("id") Integer id) {
		return ResultTemplate.getSuccessResult(service.findInfoById(id));
	}

}
