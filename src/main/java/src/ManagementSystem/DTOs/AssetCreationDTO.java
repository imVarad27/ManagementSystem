package src.ManagementSystem.DTOs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import src.ManagementSystem.Domain.ValueObject.*;

import java.util.List;

@Getter
public class AssetCreationDTO {
    private String assetName;
    private AssetPhysicalId physicalId;
    private MaterialType type;
    private MaterialType subType;
    private Location location;
    private boolean assemblyCreationSupported;
    private LifeStage lifeStage;
    private List<Property> properties;
    private List<String> reportReferenceIds;

    public AssetCreationDTO(){}
    @JsonCreator
    public AssetCreationDTO(
            @JsonProperty("assetName") String assetName,
            @JsonProperty("physicalId") AssetPhysicalId physicalId,
            @JsonProperty("type") MaterialType type,
            @JsonProperty("subType") MaterialType subType,
            @JsonProperty("location") Location location,
            @JsonProperty("assemblyCreationSupported") Boolean assemblyCreationSupported,
            @JsonProperty("lifeStage") LifeStage lifeStage,
            @JsonProperty("properties") List<Property> properties,
            @JsonProperty("reportReferenceIds") List<String> reportReferenceIds) {
        this.assetName = assetName;
        this.physicalId = physicalId;
        this.type = type;
        this.subType = subType;
        this.location = location;
        this.assemblyCreationSupported = assemblyCreationSupported;
        this.lifeStage = lifeStage;
        this.properties = properties;
        this.reportReferenceIds = reportReferenceIds;
    }

}
