package com.ManagementSystem.DTOs;

import com.ManagementSystem.Domain.ValueObject.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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

    @Size(max = 50, message = "Maximum 50 properties allowed")
    List<@Valid Property> properties,

    @Size(max = 50, message = "Maximum 50 report reference IDs allowed")
    List<@NotBlank(message = "Report reference ID must not be blank") String> reportReferenceIds
) {}