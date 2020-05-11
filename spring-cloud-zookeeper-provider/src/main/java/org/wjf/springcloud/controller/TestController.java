package org.wjf.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wjf.springcloud.api.Service;
import org.wjf.springcloud.entity.Info;

@Controller
@ResponseBody
public class TestController {

	@Autowired
	private Service service;

	@PostMapping("/createNewInfo")
	public Integer createNewInfo(Info info) {
		return service.createNewInfo(info);
	}

	@GetMapping("/findInfoById/{id}")
	public Info findInfoById(@PathVariable("id") Integer id) {
		return service.findInfoById(id);
	}

}
