package com.ManagementSystem.DTOs;

import com.ManagementSystem.Domain.ValueObject.*;

import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.List;

@Getter
@AllArgsConstructor
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
