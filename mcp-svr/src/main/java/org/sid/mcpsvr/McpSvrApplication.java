package org.sid.mcpsvr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "org.sid.mcpsvr.feign")
@EnableDiscoveryClient

public class McpSvrApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpSvrApplication.class, args);
    }

}
