package com.ManagementSystem.DTOs;

import com.ManagementSystem.Domain.ValueObject.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import java.util.List;

public record AssetUpdateDto(
    @Size(max = 255, message = "Asset name must be at most 255 characters")
    String assetName,

    @Valid
    AssetPhysicalId physicalId,

    @Valid
    MaterialType type,

    @Valid
    MaterialType subType,

    @Valid
    Location location,

    Boolean assemblyCreationSupported,

    @Valid
    LifeStage lifeStage,

    List<@Valid Property> properties,

    List<String> reportReferenceIds
) {}