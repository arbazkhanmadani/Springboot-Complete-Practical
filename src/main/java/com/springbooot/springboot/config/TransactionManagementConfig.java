package com.springbooot.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

@EnableTransactionManagement
public class TransactionManagementConfig {


	@Bean
	public AbstractPlatformTransactionManager manageTransaction(MongoDatabaseFactory dbFactory){
		return new MongoTransactionManager(dbFactory);
	}
}
