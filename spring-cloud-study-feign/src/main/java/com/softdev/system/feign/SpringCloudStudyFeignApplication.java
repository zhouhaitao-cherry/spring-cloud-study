package com.softdev.system.feign;

import com.softdev.system.feign.controller.DemoRemoteClient;
import com.softdev.system.feign.util.ApiReturnObject;
import javax.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class SpringCloudStudyFeignApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStudyFeignApplication.class,args);
		System.out.println("http://127.0.0.1:6666/feign/remote/demo/222");
	}
}
