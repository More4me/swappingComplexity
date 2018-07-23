package com.swappingComplexity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;


@SpringBootApplication
@EnableAsync
@EnableScheduling
public class swappingComplexityApplication {
    public static void main(String[] args) {
        SpringApplication.run(swappingComplexityApplication.class,args);
    }

//    @Bean(name="threadPoolTaskExecutor")
//    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
//        ThreadPoolTaskExecutor threadPoolTaskExecutor
//                = new ThreadPoolTaskExecutor();
//        threadPoolTaskExecutor.setMaxPoolSize(10);
//        threadPoolTaskExecutor.setThreadNamePrefix(
//                "ThreadPoolTaskExecutor - ");
//        return threadPoolTaskExecutor;
//    }

    @Bean(name="threadPoolTaskSchedular")
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        ThreadPoolTaskScheduler threadPoolTaskScheduler
                = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(10);
        threadPoolTaskScheduler.setThreadNamePrefix(
                "ThreadPoolTaskScheduler - ");
        return threadPoolTaskScheduler;
    }
}
