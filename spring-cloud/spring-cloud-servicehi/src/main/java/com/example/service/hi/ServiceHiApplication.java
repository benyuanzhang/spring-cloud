package com.example.service.hi;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;


/**
 * service hi启动类
 *
 * @author benyuan.zhang
 * @date 2017/8/7 10:37
 */
@SpringBootApplication
@RestController
public class ServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    private static Logger LOG = LoggerFactory.getLogger(ServiceHiApplication.class);

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/hi")
    public String callHome() {
        LOG.info("calling trace service-hi");
        return restTemplate.getForObject("http://localhost:8989/miya", String.class);
    }

    @RequestMapping("/info")
    public String info() {
        LOG.info("calling trace service-hi ");
        return "i'm service-hi";
    }

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }
}
