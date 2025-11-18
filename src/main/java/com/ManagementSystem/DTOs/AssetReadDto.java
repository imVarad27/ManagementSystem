package com.ManagementSystem.DTOs;

import com.ManagementSystem.Domain.Asset;
import com.ManagementSystem.Domain.ValueObject.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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

  
}
