package com.example.springjaxrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.springjaxrs.dao.StormtrooperDao;
import com.example.springjaxrs.dao.StormtrooperDaoImpl;

@SpringBootApplication
public class SpringJaxrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJaxrsApplication.class, args);
	}

	@Bean
	protected StormtrooperDao stormtrooperDao() {
		return new StormtrooperDaoImpl();
	}
}
