package com.ManagementSystem.Services;

import org.springframework.dao.DataAccessException;
import com.ManagementSystem.DTOs.AssetCreationDTO;
import com.ManagementSystem.Domain.Asset;
import com.ManagementSystem.Domain.ValueObject.Property;
import com.ManagementSystem.Repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetService {
    @Autowired
    private AssetRepository assetRepository;

    public Asset createAsset(AssetCreationDTO assetCreationDTO) {
        try {
            Asset asset = new Asset(assetCreationDTO);

            if (assetCreationDTO.getProperties() != null) {
                for (Property property : assetCreationDTO.getProperties()) {
                    Property.validateProperty(property);
                }
            }

            return assetRepository.save(asset);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to save asset", e);
        }
    }
}
