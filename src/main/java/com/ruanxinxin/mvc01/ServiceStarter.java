package com.ruanxinxin.mvc01;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.ruanxinxin.mvc01.service.EmployeeService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableAsync
@MapperScan("com.ruanxinxin.mvc01")
public class ServiceStarter extends SpringBootServletInitializer {
    @Autowired
    static EmployeeService employeeService;

    private static ApplicationContext context;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ServiceStarter.class);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("^^^^^^^^^^^^^^^^^^66666666§§§§§§§§§§§§§§§");
        SpringApplication.run(ServiceStarter.class);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                10,
                100,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(100),
                new ThreadFactoryBuilder().setNameFormat("XINXIN-TEST").build(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        executor.execute(() -> {
            int a = 1;
            while (true) {
                a++;
                a--;
            }
        });


    }

}
