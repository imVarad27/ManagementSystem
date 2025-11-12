package com.ManagementSystem.Domain;

import com.ManagementSystem.Domain.ValueObject.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.ManagementSystem.DTOs.AssetCreationDTO;
import com.ManagementSystem.Domain.Converter.PropertyListConverter;
import com.ManagementSystem.Domain.ValueObject.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "assets")
@Getter
@Setter
@NoArgsConstructor
public class Asset {

    @Id
    @Column(name = "asset_id", nullable = false, unique = true, updatable = false)
    private String assetId = UUID.randomUUID().toString();

    @Column(name = "asset_name")
    private String assetName;

    @Embedded
    @AttributeOverride(name = "physicalId", column = @Column(name = "physical_id"))
    private AssetPhysicalId physicalId;

    @Embedded
    @AttributeOverride(name = "type", column = @Column(name = "type"))
    private MaterialType type;

    @Embedded
    @AttributeOverride(name = "type", column = @Column(name = "sub_type"))
    private MaterialType subType;

    @Column(name = "assembly_creation_supported")
    private boolean assemblyCreationSupported;

    @Embedded
    private LifeStage lifeStage;

    @Embedded
    private Location location;

    @Convert(converter = PropertyListConverter.class)
    @Column(columnDefinition = "TEXT")
    private List<Property> properties;

    @ElementCollection
    @CollectionTable (name = "asset_report_refs")
    @Column(name = "report_reference_id")
    private List<String> reportReferenceIds;

    public Asset(AssetCreationDTO dto) {
        this.assetId = UUID.randomUUID().toString();
        this.assetName = dto.assetName();
        this.physicalId = dto.physicalId();
        this.type = dto.type();
        this.subType = dto.subType();
        this.assemblyCreationSupported = dto.assemblyCreationSupported();
        this.lifeStage = dto.lifeStage();
        this.location = dto.location();
        this.properties = dto.properties();
        this.reportReferenceIds = dto.reportReferenceIds();
    }
}
