package src.ManagementSystem.Services;

import src.ManagementSystem.DTOs.AssetCreationDTO;
import src.ManagementSystem.Domain.Asset;
import src.ManagementSystem.Repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetService {
    @Autowired
    private AssetRepository assetRepository;

    AssetService(AssetRepository assetRepository){
        this.assetRepository = assetRepository;
    }

    public void createAsset(AssetCreationDTO dto) {
        Asset asset = new Asset(dto);
        assetRepository.save(asset);
    }
}
