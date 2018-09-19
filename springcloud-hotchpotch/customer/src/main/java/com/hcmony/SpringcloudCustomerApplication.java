package com.hcmony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@MyTestAnniont
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudCustomerApplication.class, args);
	}
}
