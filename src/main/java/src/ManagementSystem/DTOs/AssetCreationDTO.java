package src.ManagementSystem.DTOs;

import lombok.Getter;
import src.ManagementSystem.Domain.ValueObject.AssetPhysicalId;
import src.ManagementSystem.Domain.ValueObject.MaterialType;

@Getter
public class AssetCreationDTO {
    private String assetName;
    private AssetPhysicalId physicalId;
    private MaterialType type;
    private MaterialType subType;

    public AssetCreationDTO() {}

    public AssetCreationDTO(String assetName, AssetPhysicalId physicalId,
                            MaterialType type, MaterialType subtype) {
        this.assetName = assetName;
        this.physicalId = physicalId;
        this.type = type;
        this.subType = subtype;
    }

}
