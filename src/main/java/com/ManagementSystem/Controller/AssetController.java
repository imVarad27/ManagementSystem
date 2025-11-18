package com.ManagementSystem.Controller;

import com.ManagementSystem.DTOs.AssetUpdateDto;
import com.ManagementSystem.Services.IAssetService;
import org.springframework.http.ResponseEntity;
import com.ManagementSystem.DTOs.AssetCreationDTO;
import com.ManagementSystem.Domain.Asset;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/asset")
public class AssetController {

    @Autowired
    private IAssetService assetService;

    @PostMapping
    public ResponseEntity<?> createAsset(@Valid @RequestBody AssetCreationDTO asset) {

            Asset createdAsset = assetService.createAsset(asset);
            return ResponseEntity.ok(createdAsset);
    }

    @GetMapping
    public Object getAssets(@RequestParam(required = false) String physicalId) {
        if (physicalId != null) {
            return assetService.getAssetByPhysicalId(physicalId);
        }
        return assetService.getAssets();
    }

    @PutMapping
    public ResponseEntity<?> updateAsset(
            @RequestParam String assetId,
            @Valid @RequestBody AssetUpdateDto assetUpdateDto) {

        Asset updated = assetService.updateAsset(assetId, assetUpdateDto);
        return ResponseEntity.ok(updated);
    }


}
