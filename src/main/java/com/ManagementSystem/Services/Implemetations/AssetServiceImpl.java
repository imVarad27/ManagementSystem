package com.ManagementSystem.Services.Implemetations;

import com.ManagementSystem.DTOs.AssetCreationDTO;
import com.ManagementSystem.DTOs.AssetReadDto;
import com.ManagementSystem.DTOs.AssetUpdateDto;
import com.ManagementSystem.Domain.Asset;
import com.ManagementSystem.Domain.ValueObject.Property;
import com.ManagementSystem.Mapper.AssetMapper;
import com.ManagementSystem.Repository.AssetRepository;
import com.ManagementSystem.Services.AssetService;
import com.ManagementSystem.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor 
@Transactional 
@CacheConfig(cacheNames = "assets")
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;
    private final AssetMapper assetMapper;

     @CachePut(key = "#result.physicalId")
    public AssetReadDto createAsset(AssetCreationDTO dto) {
        if (dto.properties() != null) {
            dto.properties().forEach(Property::validateProperty);
        }
        Asset saved = this.assetMapper.toEntity(dto);
        this.assetRepository.save(saved);
        return assetMapper.toReadDto(saved);
    }

    @Transactional(readOnly = true)
    public List<AssetReadDto> getAssets() {
        List<Asset> assets =  assetRepository.findAll();
        return this.assetMapper.tReadDtoList(assets);
                
    }

   
    @Cacheable(key = "#physicalId")
   @Transactional(readOnly = true)
    public AssetReadDto getAssetByPhysicalId(String physicalId) {
    Asset asset = assetRepository
        .findByPhysicalId_Id(physicalId)
        .orElseThrow(() -> new ResourceNotFoundException("Asset", "physicalId", physicalId));

    return this.assetMapper.toReadDto(asset); 
}

    @CachePut(key = "#result.physicalId")
  @Transactional
public AssetReadDto updateAsset(String assetId, AssetUpdateDto dto) {
    if (assetId == null) {
        throw new ResourceNotFoundException("assetId", null);
    }

    if (dto.properties() != null) {
        dto.properties().forEach(Property::validateProperty);
    }
    Asset asset = assetRepository.findById(assetId)
        .orElseThrow(() -> new ResourceNotFoundException("Asset", "id", assetId));

    assetMapper.updateFromDto(dto, asset);

    asset = assetRepository.save(asset);
    return assetMapper.toReadDto(asset);
}

    @CacheEvict(key = "#physicalId")
   @Transactional
public void deleteByPhysicalId(String physicalId) {
    if (physicalId == null) {
        throw new ResourceNotFoundException("Asset", "id", null);
    }

    Asset asset = assetRepository.findByPhysicalId_Id(physicalId)
        .orElseThrow(() -> new ResourceNotFoundException("Asset", "id", physicalId));

    assetRepository.delete(asset);
}

}
