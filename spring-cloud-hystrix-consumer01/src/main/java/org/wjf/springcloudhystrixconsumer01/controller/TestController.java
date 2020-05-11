package org.wjf.springcloudhystrixconsumer01.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wjf.springcloud.entity.Info;
import org.wjf.springcloud.vo.ResultTemplate;
import org.wjf.springcloudhystrixconsumer01.service.TestService;

@RestController
@RequestMapping("/consumer/test")
public class TestController {

	@Autowired
	private TestService testService;

	@GetMapping("/test/getInfoById/{id}")
	@HystrixCommand
	public ResultTemplate<Info> getInfoById(@PathVariable("id") Integer id) {
		final ResultTemplate<Info> infoById = testService.getInfoById(id);
		System.out.println(infoById.toString());
		return testService.getInfoById(id);
	}

	@GetMapping("/test/getTimeOutInfoById/{id}")
	@HystrixCommand(commandProperties = {@HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds" ,value ="7000" )})
	public ResultTemplate<Info> getTimeOutInfoById(@PathVariable("id") Integer id) {
		return testService.getTimeOutInfoById(id);
	}
}
