package org.wjf.springcloudhystrixconsumer01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * {@link org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker} 注解
 * 替代了注解：
 * {@link org.springframework.cloud.netflix.hystrix.EnableHystrix}
 */
@EnableCircuitBreaker
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class HystrixConsumerMain {
	public static void main(String[] args) {
		SpringApplication.run(HystrixConsumerMain.class, args);
	}
}
