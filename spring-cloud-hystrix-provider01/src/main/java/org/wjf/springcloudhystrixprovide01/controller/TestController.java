package org.wjf.springcloudhystrixprovide01.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

	/**
	 * fallbackMethod属性指向的方法必须在同一类中
	 * @param id
	 * @return
	 */
	@GetMapping("/getTimeOutInfoById/{id}")
	@HystrixCommand(fallbackMethod = "getTimeOutInfoById",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "7000"),
			@HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启熔断器
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "2"),//请求阈值,请求超过阈值将为熔断
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "1000"),//时间窗口期
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//最高失败率
			//即在时间窗口期的时间内（毫秒），在请求次数中的请求如果失败率达到了最高失败率，熔断器断开
			//在熔断器断开过后，当过了时间窗口期的时间后，hystrix会放行一个请求，如果此次请求成功，会恢复主逻辑，否则继续断开
	})
	public ResultTemplate<Info> getTimeOutInfoById(@PathVariable("id") Integer id) {
		logger.info("***进来了一个新请求");
//		try {
//			TimeUnit.SECONDS.sleep(3);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return ResultTemplate.getSuccessResult(service.findInfoById(id));
	}

	public ResultTemplate<Info> getTimeOutInfoFallBack(Integer id){
		final Info info = new Info();
		return ResultTemplate.getFailResult(info);
	}

}
