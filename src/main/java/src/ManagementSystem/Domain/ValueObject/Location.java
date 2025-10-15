package src.ManagementSystem.Domain.ValueObject;

public record Location(String location) {
    @Override
    public String toString() {return location;}
}
