package src.ManagementSystem.Domain;

import org.springframework.data.mongodb.core.mapping.Field;
import src.ManagementSystem.DTOs.AssetCreationDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import src.ManagementSystem.Domain.ValueObject.AssetPhysicalId;
import src.ManagementSystem.Domain.ValueObject.LifeStage;
import src.ManagementSystem.Domain.ValueObject.MaterialType;

import java.util.UUID;

@Setter
@Getter
public class Asset {

    @Id
    private String assetId;

    @Field
    private String assetName;

    @Field
    private AssetPhysicalId physicalId;

    @Field
    private MaterialType type;

    @Field
    private MaterialType subType;

    public boolean isAssemblyCreationSupported;

    public LifeStage lifeStage;

    public Asset() {} 

    public Asset(AssetCreationDTO dto) {
        this.assetName = dto.getAssetName();
        this.assetId = UUID.randomUUID().toString();
        this.physicalId = dto.getPhysicalId();
        this.type = dto.getType();
        this.subType = dto.getSubType();
        this.isAssemblyCreationSupported = dto.isAssemblyCreationSupported();
        this.lifeStage = dto.getLifeStage();
    }
}
