package src.ManagementSystem.Domain.ValueObject;

import jakarta.validation.constraints.NotNull;

public record Location(String location) {
    @Override
    public @NotNull String toString() {return location;}
}
