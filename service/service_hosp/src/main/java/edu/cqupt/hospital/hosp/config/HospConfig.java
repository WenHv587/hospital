package edu.cqupt.hospital.hosp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author LWenH
 * @create 2023/4/1 - 16:08
 */
@Configuration
@MapperScan("edu.cqupt.hospital.hosp.mapper")
public class HospConfig {
}
