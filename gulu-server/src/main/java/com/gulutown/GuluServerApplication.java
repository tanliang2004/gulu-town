package com.gulutown;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class GuluServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuluServerApplication.class, args);
        log.info("hello spring");
    }

}
