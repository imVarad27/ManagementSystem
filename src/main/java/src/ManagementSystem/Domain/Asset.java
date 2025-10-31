package src.ManagementSystem.Domain;

import org.springframework.data.mongodb.core.mapping.Document;
import src.ManagementSystem.DTOs.AssetCreationDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import src.ManagementSystem.Domain.ValueObject.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Document(collection = "assets")
public class Asset {

    @Id
    private String assetId;

    private String assetName;
    private AssetPhysicalId physicalId;
    private MaterialType  type;
    private MaterialType  subType;
    private boolean assemblyCreationSupported;
    private LifeStage lifeStage;
    private Location location;
    private List<Property> properties;
    private List<String> reportReferenceIds;

    public Asset() {
        this.assetId = UUID.randomUUID().toString();
    }

    public Asset(AssetCreationDTO dto) {
        this.assetName = dto.getAssetName();
        this.assetId = UUID.randomUUID().toString();
        this.physicalId = dto.getPhysicalId();
        this.type = dto.getType();
        this.subType = dto.getSubType();
        this.assemblyCreationSupported = dto.isAssemblyCreationSupported();
        this.lifeStage = dto.getLifeStage();
        this.reportReferenceIds = dto.getReportReferenceIds();
        this.properties = dto.getProperties();
        this.location = dto.getLocation();
    }
}
