package com.health.gymnasium.configuration;

import com.health.gymnasium.model.HealthData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.ForkJoinPool;

@Configuration
public class ThreadConfig {

    @Bean(name = "asyncThreadPooling")
    public ForkJoinPool healthThreadPool() {
        System.out.println("Total Available processor "+Runtime.getRuntime().availableProcessors());
        return new ForkJoinPool(Runtime.getRuntime().availableProcessors());
    }

}
