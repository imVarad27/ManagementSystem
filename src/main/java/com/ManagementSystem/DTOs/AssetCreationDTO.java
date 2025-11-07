package com.ManagementSystem.DTOs;

import com.ManagementSystem.Domain.ValueObject.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

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
            String assetName,
            AssetPhysicalId physicalId,
            MaterialType type,
            MaterialType subType,
            Location location,
            Boolean assemblyCreationSupported,
            LifeStage lifeStage,
            List<Property> properties,
            List<String> reportReferenceIds) {
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
