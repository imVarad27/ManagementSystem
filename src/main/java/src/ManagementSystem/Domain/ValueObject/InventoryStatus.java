package src.ManagementSystem.Domain.ValueObject;

public record InventoryStatus(String Status){
    @Override
    public String Status() {
        return Status;
    }
}
