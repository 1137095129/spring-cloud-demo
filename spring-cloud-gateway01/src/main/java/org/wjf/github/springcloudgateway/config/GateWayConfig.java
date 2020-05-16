package org.wjf.github.springcloudgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes().route("spring-cloud-hystrix-provider-01", predicateSpec ->
				predicateSpec.path("/test/getInfoById/**")
						.uri("http://localhost:8849")
		).build();
	}
}
