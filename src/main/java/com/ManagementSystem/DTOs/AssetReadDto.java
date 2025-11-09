package com.ManagementSystem.DTOs;

import com.ManagementSystem.Domain.Asset;
import com.ManagementSystem.Domain.ValueObject.*;
import lombok.Getter;

import java.util.List;

@Getter
public class AssetReadDto {
    private String assetName;
    private AssetPhysicalId physicalId;
    private MaterialType type;
    private MaterialType subType;
    private Location location;
    private boolean assemblyCreationSupported;
    private LifeStage lifeStage;
    private List<Property> properties;
    private List<String> reportReferenceIds;

    public AssetReadDto (){}

    public AssetReadDto(Asset asset) {
        this.assetName = asset.getAssetName();
        this.physicalId = asset.getPhysicalId();
        this.type = asset.getType();
        this.subType = asset.getSubType();
        this.location = asset.getLocation();
        this.assemblyCreationSupported = asset.isAssemblyCreationSupported();
        this.lifeStage = asset.getLifeStage();
        this.properties = asset.getProperties();
        this.reportReferenceIds = asset.getReportReferenceIds();
    }
}
