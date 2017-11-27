package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class DoctorService1Application implements CommandLineRunner{
	
	@Autowired
	private DataSource ds;

	public static void main(String[] args) {
		SpringApplication.run(DoctorService1Application.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("current data source is:\t"+ds);
		System.out.println("i am in ");
	}
}
