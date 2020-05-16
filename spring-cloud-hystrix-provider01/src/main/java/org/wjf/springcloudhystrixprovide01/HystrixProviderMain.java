package org.wjf.springcloudhystrixprovide01;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

//@EnableHystrix
@SpringBootApplication
@EnableDiscoveryClient
public class HystrixProviderMain {
	public static void main(String[] args) {
		SpringApplication.run(HystrixProviderMain.class,args);
	}

	/**
	 * 配置hystrix图形化监控界面
	 * @return
	 */
	@Bean
	public ServletRegistrationBean<HystrixMetricsStreamServlet> servletRegistrationBean(){
		HystrixMetricsStreamServlet servlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(servlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/hystrix");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}
}
