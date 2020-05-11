package org.wjf.springcloudhystrixprovide01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

//@EnableHystrix
@SpringBootApplication
@EnableDiscoveryClient
public class HystrixProviderMain {
	public static void main(String[] args) {
		SpringApplication.run(HystrixProviderMain.class,args);
	}
}