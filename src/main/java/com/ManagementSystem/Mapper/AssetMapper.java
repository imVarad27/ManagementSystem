package com.ManagementSystem.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.ManagementSystem.DTOs.AssetCreationDTO;
import com.ManagementSystem.DTOs.AssetReadDto;
import com.ManagementSystem.DTOs.AssetUpdateDto;
import com.ManagementSystem.Domain.Asset;

@Mapper(componentModel = "spring",
nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssetMapper {
    Asset toEntity(AssetCreationDTO dto);
    void updateFromDto(AssetUpdateDto dto,@MappingTarget Asset asset);
    AssetReadDto toReadDto(Asset asset);
    List<AssetReadDto> tReadDtoList(List<Asset> assets);
    
    
}
