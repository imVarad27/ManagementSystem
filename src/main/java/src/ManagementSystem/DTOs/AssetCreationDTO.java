package src.ManagementSystem.DTOs;

import lombok.Getter;

@Getter
public class AssetCreationDTO {
    private String assetName;
    private String physicalId;

    public AssetCreationDTO() {}

    public AssetCreationDTO(String assetName, String physicalId) {
        this.assetName = assetName;
        this.physicalId = physicalId;
    }

}
