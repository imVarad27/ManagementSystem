package com.ManagementSystem.DTOs;

import com.ManagementSystem.Domain.ValueObject.*;
import java.util.List;

public record AssetCreationDTO(
        String assetName,
        AssetPhysicalId physicalId,
        MaterialType type,
        MaterialType subType,
        Location location,
        boolean assemblyCreationSupported,
        LifeStage lifeStage,
        List<Property> properties,
        List<String> reportReferenceIds
) {}
