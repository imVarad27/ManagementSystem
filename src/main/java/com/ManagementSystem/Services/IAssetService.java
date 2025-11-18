package com.ManagementSystem.Services;

import com.ManagementSystem.DTOs.AssetCreationDTO;
import com.ManagementSystem.DTOs.AssetReadDto;
import com.ManagementSystem.DTOs.AssetUpdateDto;
import com.ManagementSystem.Domain.Asset;

import java.util.List;

public interface IAssetService {

    Asset createAsset (AssetCreationDTO dto);
    List<AssetReadDto> getAssets();
    AssetReadDto getAssetByPhysicalId(String physicalId);
    Asset updateAsset(String assetId, AssetUpdateDto dto);
}
