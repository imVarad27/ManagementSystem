package src.ManagementSystem.Services;

import org.springframework.dao.DataAccessException;
import src.ManagementSystem.DTOs.AssetCreationDTO;
import src.ManagementSystem.Domain.Asset;
import src.ManagementSystem.Repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetService {
    @Autowired
    private AssetRepository assetRepository;

    public Asset createAsset(Asset asset) {
        try {
            return assetRepository.save(asset);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to save asset", e);
        }
    }
}
