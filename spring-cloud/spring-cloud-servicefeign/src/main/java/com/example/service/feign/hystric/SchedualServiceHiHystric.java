package com.example.service.feign.hystric;

import com.example.service.feign.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * 断路器
 *
 * @author benyuan.zhang
 * @date 2017/8/4 15:06
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi{
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}
