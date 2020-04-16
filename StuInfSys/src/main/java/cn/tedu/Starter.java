package cn.tedu;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan("cn.tedu.mapper")
public class Starter{
    public static void main(String[] args) {
        SpringApplication.run(Starter.class,args);
    }
}
