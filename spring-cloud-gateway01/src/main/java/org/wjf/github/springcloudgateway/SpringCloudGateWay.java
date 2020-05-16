package org.wjf.github.springcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudGateWay {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGateWay.class,args);
	}
}
