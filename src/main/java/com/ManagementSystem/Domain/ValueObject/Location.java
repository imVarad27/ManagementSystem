package com.ManagementSystem.Domain.ValueObject;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class Location {
    private String location;

    public Location(String location) {
        this.location = location;
    }
}
