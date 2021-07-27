package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dao")// 指定MyBatis扫描的包，以便将数据访问接口注册为bean
public class PersonalHealthAlterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalHealthAlterApplication.class, args);
	}

}
