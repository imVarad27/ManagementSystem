package src.ManagementSystem.Domain.ValueObject;

import jakarta.validation.constraints.NotNull;

public record AssetPhysicalId(String id) {
    public String Id(){
      return id;
    }
}
