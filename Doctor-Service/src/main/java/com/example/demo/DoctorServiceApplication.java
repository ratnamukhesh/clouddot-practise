package com.example.demo;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
@EnableJpaRepositories("com.example.demo.dao")
@EntityScan("com.example.demo.vo")
public class DoctorServiceApplication implements CommandLineRunner{
	@Autowired
	DataSource datasource;

	public static void main(String[] args) {
		SpringApplication.run(DoctorServiceApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("command liner   :  \t "+arg0);
		System.out.println("Data Source   :  \t "+datasource);	
		
		
	}
	
	
	
	
	
}
