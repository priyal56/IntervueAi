package com.priyal.intervueai.backend.controller;

import com.priyal.intervueai.backend.dto.HealthResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public HealthResponse health() {
        return new HealthResponse("UP", "intervueai-backend", "1.0.0");
    }
}
