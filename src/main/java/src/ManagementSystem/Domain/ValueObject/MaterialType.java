package src.ManagementSystem.Domain.ValueObject;

public record MaterialType(String type) {
    @Override
    public String toString() {
        return type;
    }
}



