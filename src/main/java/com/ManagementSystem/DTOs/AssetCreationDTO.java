package com.ManagementSystem.DTOs;


import com.ManagementSystem.Domain.ValueObject.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record AssetCreationDTO(
    @NotBlank(message = "Asset name must not be blank")
    String assetName,

    @NotNull(message = "Physical ID must not be null")
    @Valid
    AssetPhysicalId physicalId,

    @Valid
    MaterialType type,

    @Valid
    MaterialType subType,

    @NotNull(message = "Location must not be null")
    @Valid
    Location location,

    @NotNull(message = "Assembly creation flag must not be null")
    Boolean assemblyCreationSupported,

    @Valid
    LifeStage lifeStage,

    List<@Valid Property> properties,

    List<@NotBlank(message = "Report reference ID must not be blank") String> reportReferenceIds
) {}