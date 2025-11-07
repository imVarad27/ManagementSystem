package com.ManagementSystem.Domain.ValueObject;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class MaterialType {
    private String type;

    public MaterialType(String type) {
        this.type = type;
    }
}
