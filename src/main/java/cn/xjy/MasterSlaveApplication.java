package cn.xjy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName:MasterSlaveApplication
 * Function:springboot启动类
 * date: 2018年08月02日
 *
 * @author 许嘉阳
 */
@SpringBootApplication
@MapperScan("cn.xjy.mapper")
public class MasterSlaveApplication {
    public static void main(String[] args) {
        SpringApplication.run(MasterSlaveApplication.class, args);
    }
}