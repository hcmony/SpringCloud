package com.hcmony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

/**
 * 也可直接去下载使用，不用创建服务项目
 * 下载地址:https://dl.bintray.com/openzipkin/maven/io/zipkin/java/zipkin-server/
 * 也可访问链接: https://pan.baidu.com/s/1eRSy1eHv3XahlAHHbA1kyA 提取码: pkv6 复制这段内容后打开百度网盘手机App，操作更方便哦
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class SleuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SleuthApplication.class, args);
	}
}
