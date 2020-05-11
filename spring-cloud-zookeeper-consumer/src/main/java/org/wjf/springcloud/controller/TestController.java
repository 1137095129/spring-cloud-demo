package org.wjf.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.wjf.springcloud.entity.Info;
import org.wjf.springcloud.vo.ResultTemplate;

import java.util.List;

@Controller
@ResponseBody
public class TestController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;



	private final static String url = "http://zookeeper-provider/";

	@PostMapping("/createNewInfo")
	public ResultTemplate<Info> createNewInfo(Info info){
//		List<ServiceInstance> instances = discoveryClient.getInstances("");
//		for (ServiceInstance instance : instances) {
//			instance.
//		}
		return ResultTemplate.getFailResult();
	}
}
