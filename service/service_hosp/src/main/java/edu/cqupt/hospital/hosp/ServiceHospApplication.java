package edu.cqupt.hospital.hosp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author LWenH
 * @create 2023/4/1 - 15:01
 */
@SpringBootApplication
@ComponentScan(basePackages = "edu.cqupt")
public class ServiceHospApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHospApplication.class, args);
    }
}
