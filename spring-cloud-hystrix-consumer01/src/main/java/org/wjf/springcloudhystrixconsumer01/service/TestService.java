package org.wjf.springcloudhystrixconsumer01.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.wjf.springcloud.entity.Info;
import org.wjf.springcloud.vo.ResultTemplate;

@Component
@FeignClient(value = "SPRING-CLOUD-HYSTRIX-PROVIDER-01")
public interface TestService {

	@GetMapping("/test/getInfoById/{id}")
	ResultTemplate<Info> getInfoById(@PathVariable("id") Integer id);

	@GetMapping("/test/getTimeOutInfoById/{id}")
	ResultTemplate<Info> getTimeOutInfoById(@PathVariable("id") Integer id);

}
