package com.ManagementSystem.Services;

import com.ManagementSystem.DTOs.AssetCreationDTO;
import com.ManagementSystem.DTOs.AssetReadDto;
import com.ManagementSystem.DTOs.AssetUpdateDto;
import com.ManagementSystem.Domain.Asset;
import com.ManagementSystem.Domain.ValueObject.Property;
import com.ManagementSystem.Repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor // replaces @Autowired
@Transactional // ensures atomic DB operations
public class AssetService {

    private final AssetRepository assetRepository;

    public Asset createAsset(AssetCreationDTO dto) {
        if (dto.properties() != null) {
            dto.properties().forEach(Property::validateProperty);
        }
        return assetRepository.save(new Asset(dto));
    }

    @Transactional(readOnly = true)
    public List<AssetReadDto> getAssets() {
        return assetRepository.findAll()
                .stream()
                .map(AssetReadDto::new)
                .toList(); // modern Java 17+
    }

    @Transactional(readOnly = true)
    public AssetReadDto getAssetByPhysicalId(String physicalId) {
        return new AssetReadDto(assetRepository.findByPhysicalId_Id(physicalId));
    }

    @Transactional
    public Asset updateAsset(String assetId, AssetUpdateDto assetUpdateDto){
        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        asset.updateFromDto(assetUpdateDto);

        return assetRepository.save(asset);
    }
}
