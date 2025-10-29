package src.ManagementSystem.DTOs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class AssetCreationDTO {
    private String assetName;
    private String physicalId;
    private String type;
    private String subType;
    private boolean assemblyCreationSupported;
    private String lifeStage;
    private List<String> properties;
    private List<String> reportReferenceIds;

    public AssetCreationDTO(){}
    @JsonCreator
    public AssetCreationDTO(
            @JsonProperty("assetName") String assetName,
            @JsonProperty("physicalId") String physicalId,
            @JsonProperty("type") String type,
            @JsonProperty("subType") String subType,
            @JsonProperty("assemblyCreationSupported") Boolean assemblyCreationSupported,
            @JsonProperty("lifeStage") String lifeStage,
            @JsonProperty("properties") List<String> properties,
            @JsonProperty("reportReferenceIds") List<String> reportReferenceIds) {
        this.assetName = assetName;
        this.physicalId = physicalId;
        this.type = type;
        this.subType = subType;
        this.assemblyCreationSupported = assemblyCreationSupported;
        this.lifeStage = lifeStage;
        this.properties = properties;
        this.reportReferenceIds = reportReferenceIds;
    }

}
