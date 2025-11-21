package com.ManagementSystem.Services;

import com.ManagementSystem.DTOs.AssetCreationDTO;
import com.ManagementSystem.DTOs.AssetReadDto;
import com.ManagementSystem.DTOs.AssetUpdateDto;

import java.util.List;

public interface AssetService {

    AssetReadDto createAsset(AssetCreationDTO dto);

    List<AssetReadDto> getAssets();

    AssetReadDto getAssetByPhysicalId(String physicalId);

    AssetReadDto updateAsset(String assetId, AssetUpdateDto dto);

    void deleteByPhysicalId(String physicalId);
}
