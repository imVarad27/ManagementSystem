package src.ManagementSystem.Domain.ValueObject;

public record AssetPhysicalId(String id) {
    @Override
    public String toString() {
        return id;
    }
}
