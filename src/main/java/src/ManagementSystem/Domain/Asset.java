package src.ManagementSystem.Domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
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
    private String physicalId;
    private String type;
    private String subType;
    private boolean assemblyCreationSupported;
    private String lifeStage;
    private String location;
    private List<String> properties;
    private List<String> reportReferenceIds;

    public Asset() {
        this.assetId = UUID.randomUUID().toString();
    }
}
