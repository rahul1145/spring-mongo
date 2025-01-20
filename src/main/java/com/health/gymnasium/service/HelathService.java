package com.health.gymnasium.service;

import com.health.gymnasium.model.HealthData;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface HelathService {
    public CompletableFuture<List<HealthData>> findAll();
    public CompletableFuture<List<HealthData>> insert(HealthData data);
}
