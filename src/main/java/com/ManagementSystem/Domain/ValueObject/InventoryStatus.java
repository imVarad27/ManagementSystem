package com.ManagementSystem.Domain.ValueObject;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class InventoryStatus {
    private String status;

    public InventoryStatus(String status) {
        this.status = status;
    }
}
