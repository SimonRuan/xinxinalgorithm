package com.ruanxinxin.mvc01.config;

import com.ruanxinxin.mvc01.bean.MyFactoryBean;
import org.springframework.cache.*;
import org.springframework.cache.annotation.*;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching //启用缓存
public class CacheConfig {

    //声明缓存管理器
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }


//    @Bean
//    public MyFactoryBean getFactoryBean(){
//        return new MyFactoryBean();
//    }

}
