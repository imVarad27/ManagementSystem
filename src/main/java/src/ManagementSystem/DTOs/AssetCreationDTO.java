package src.ManagementSystem.DTOs;

import lombok.Getter;
import src.ManagementSystem.Domain.ValueObject.AssetPhysicalId;
import src.ManagementSystem.Domain.ValueObject.LifeStage;
import src.ManagementSystem.Domain.ValueObject.MaterialType;

@Getter
public class AssetCreationDTO {
    private String assetName;
    private AssetPhysicalId physicalId;
    private MaterialType type;
    private MaterialType subType;
    private boolean isAssemblyCreationSupported;
    private LifeStage lifeStage;

    public AssetCreationDTO() {}

    public AssetCreationDTO(String assetName, AssetPhysicalId physicalId,
                            MaterialType type, MaterialType subtype,
                            boolean isAssemblyCreationSupported, LifeStage lifestage) {
        this.assetName = assetName;
        this.physicalId = physicalId;
        this.type = type;
        this.subType = subtype;
        this.isAssemblyCreationSupported = isAssemblyCreationSupported;
        this.lifeStage = lifestage;
    }

}
