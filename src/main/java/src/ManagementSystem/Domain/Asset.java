package src.ManagementSystem.Domain;

import src.ManagementSystem.DTOs.AssetCreationDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Setter
@Getter
public class Asset {

    @Id
    private String assetId;
    private String assetName;
    private String physicalId;
    private String materialType;

    public Asset() {} 

    public Asset(AssetCreationDTO dto) {
        this.assetName = dto.getAssetName();
        this.assetId = UUID.randomUUID().toString();
        this.physicalId = dto.getPhysicalId();
        this.materialType = "Default";
    }
}
