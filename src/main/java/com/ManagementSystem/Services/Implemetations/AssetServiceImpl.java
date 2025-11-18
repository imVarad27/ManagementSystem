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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor // replaces @Autowired
@Transactional // ensures atomic DB operations
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;
    private final AssetMapper assetMapper;

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

   @Transactional(readOnly = true)
    public AssetReadDto getAssetByPhysicalId(String physicalId) {
    Asset asset = assetRepository
        .findByPhysicalId_Id(physicalId)
        .orElseThrow(() -> new ResourceNotFoundException("Asset", "physicalId", physicalId));

    return this.assetMapper.toReadDto(asset); // or manual mapping
}

    @Transactional
    public AssetReadDto updateAsset(String assetId, AssetUpdateDto dto) {
        Asset asset = null;
        if(assetId != null){
         asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset","id",assetId));
        }
        else{
            throw new ResourceNotFoundException("assetId",assetId);
        }

        if (dto.properties() != null) {
            dto.properties().forEach(Property::validateProperty);
        }

        return this.assetMapper.toReadDto(asset);

       
    }

    @Transactional
    public void deleteByPhysicalId(String physicalId){
        Asset asset = null;
        if(physicalId != null){
        asset = this.assetRepository.findByPhysicalId_Id(physicalId)
        .orElseThrow(()->new ResourceNotFoundException("Asset","id",physicalId));
        }else{
            throw new ResourceNotFoundException("Asset","id",physicalId);
        }
        if(asset!=null){
        this.assetRepository.delete(asset);
        }
        else{
            throw new ResourceNotFoundException("Asset","id",physicalId);
        }
    }

}
