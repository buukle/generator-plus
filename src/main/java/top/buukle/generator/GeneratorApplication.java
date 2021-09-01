package top.buukle.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan({"top.buukle.generator.dao"})
@EnableTransactionManagement
@EnableSwagger2
@SpringBootApplication(scanBasePackages = {"top.buukle.*"})
public class GeneratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(GeneratorApplication.class, args);
        System.out.println("启动成功!");
    }
}
