package com.gulutown;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Slf4j
@EnableCaching // 开启缓存注解
@EnableTransactionManagement // 开启组件事务管理
public class GuluServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuluServerApplication.class, args);
    }

}
