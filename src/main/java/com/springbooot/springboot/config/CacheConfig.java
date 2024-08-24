package com.springbooot.springboot.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//Enable caching in spring boot
@EnableCaching
public class CacheConfig {

    @Bean
    public ConcurrentMapCacheManager cacheManager1(){
    	//we have to use this key on service where we apply cache
        return new ConcurrentMapCacheManager("users");
        //for multiple objects
        //return new ConcurrentMapCacheManager("users", "products", "orders");
    }
    
    
}