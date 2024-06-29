package com.crud.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class })
public class MsCrudEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCrudEventApplication.class, args);
	}

}
