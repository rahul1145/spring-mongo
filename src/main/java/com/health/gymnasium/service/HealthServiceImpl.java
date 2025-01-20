package com.health.gymnasium.service;

import com.health.gymnasium.HealthDataRepository;
import com.health.gymnasium.model.HealthData;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

@Service
public class HealthServiceImpl implements HelathService{

    @Autowired
    HealthDataRepository healthDataRepository;

    @Autowired
    private ForkJoinPool asyncThreadPooling;

    //using ForkJoinPoo to share resources based on available and busy threads
    @Override
    @CircuitBreaker(name = "healthService", fallbackMethod = "fallbackFindAll")
    public CompletableFuture<List<HealthData>> findAll() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Current Thread Running" + Thread.currentThread());
            return healthDataRepository.findAll();
        }, asyncThreadPooling);
}

    @Override
    public CompletableFuture<List<HealthData>> insert(HealthData data) {
        return CompletableFuture.supplyAsync(() -> {
            if (data!=null) {
                healthDataRepository.insert(data);
            }
            return Collections.emptyList();
        }, asyncThreadPooling);
    }


    //Return empty Array incase of fallback
    public CompletableFuture<List<HealthData>> fallbackFindAll(){
        return CompletableFuture.completedFuture(List.of());
    }

//    @Override
//    public List<HealthData> findAll() {
//        return healthDataRepository.findAll();
//    }


}
