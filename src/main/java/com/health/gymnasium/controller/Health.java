package com.health.gymnasium.controller;

import com.health.gymnasium.model.HealthData;
import com.health.gymnasium.service.HelathService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class Health {

    @Autowired
    HelathService helathService;

    public Health( HelathService helathService) {
        this.helathService = helathService;
    }

    @RequestMapping(value="/")
    public  void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/data")
    public CompletableFuture<List<HealthData>> getHealthData() {
        return  helathService.findAll();
    }

    @Operation(
            summary = "Post a HealthData object",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "HealthData object",
                    required = true,
                    content = @Content(schema = @Schema(implementation = HealthData.class))
            )
    )
    @PostMapping("/post")
    public CompletableFuture<List<HealthData>> postHealthData(@Valid @RequestBody HealthData healthData) {
        return helathService.insert(healthData);
    }
}
