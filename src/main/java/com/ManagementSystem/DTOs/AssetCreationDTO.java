package com.ManagementSystem.DTOs;


import com.ManagementSystem.Domain.ValueObject.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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

    @Size(max = 50, message = "Maximum 50 properties allowed")
    List<@Valid Property> properties,

    @Size(max = 50, message = "Maximum 50 report reference IDs allowed")
    List<@NotBlank(message = "Report reference ID must not be blank") String> reportReferenceIds
) {}