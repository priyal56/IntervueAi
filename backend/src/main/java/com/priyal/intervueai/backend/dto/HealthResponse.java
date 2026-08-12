package com.priyal.intervueai.backend.dto;

public record HealthResponse(
        String status,
        String application,
        String version
) {
}