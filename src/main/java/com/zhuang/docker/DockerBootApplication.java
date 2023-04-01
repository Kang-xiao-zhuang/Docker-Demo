package com.zhuang.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * description: DockerBootApplication
 * date: 2023/3/31 13:19
 * author: Zhuang
 * version: 1.0
 */
@SpringBootApplication
@MapperScan("com.zhuang.docker.mapper")
public class DockerBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerBootApplication.class, args);
    }

}
