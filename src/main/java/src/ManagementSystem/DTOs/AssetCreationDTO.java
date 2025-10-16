package src.ManagementSystem.DTOs;

import lombok.Getter;
import src.ManagementSystem.Domain.ValueObject.AssetPhysicalId;
import src.ManagementSystem.Domain.ValueObject.LifeStage;
import src.ManagementSystem.Domain.ValueObject.MaterialType;
import src.ManagementSystem.Domain.ValueObject.Property;

import java.util.List;

@Getter
public class AssetCreationDTO {
    private String assetName;
    private AssetPhysicalId physicalId;
    private MaterialType type;
    private MaterialType subType;
    private boolean isAssemblyCreationSupported;
    private LifeStage lifeStage;
    private List<Property> properties;
    private List<String> reportReferenceIds;

    public Boolean isAssemblyCreationSupported() {
        return isAssemblyCreationSupported;
    }

    public AssetCreationDTO() {}

    public AssetCreationDTO(String assetName, AssetPhysicalId physicalId,
                            MaterialType type, MaterialType subtype,
                            boolean isAssemblyCreationSupported, LifeStage lifestage,
                            List<Property> properties, List<String> reportReferenceIds) {
        this.assetName = assetName;
        this.physicalId = physicalId;
        this.type = type;
        this.subType = subtype;
        this.isAssemblyCreationSupported = isAssemblyCreationSupported;
        this.lifeStage = lifestage;
        this.properties = properties;
        this.reportReferenceIds = reportReferenceIds;
    }

}
