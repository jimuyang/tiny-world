package me.ele.sample.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author: Yang Fan
 * @date: 2019-05-28
 * @desc:
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:pylon.xml"})
public class EchoApp {

    public static void main(String[] args) {
        SpringApplication.run(EchoApp.class, args);
    }
}
