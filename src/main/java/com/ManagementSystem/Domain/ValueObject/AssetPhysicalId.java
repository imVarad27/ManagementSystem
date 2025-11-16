package com.ManagementSystem.Domain.ValueObject;

import jakarta.persistence.Column;

public record AssetPhysicalId(
        @Column (nullable = false, unique = true)
        String id) {
}
