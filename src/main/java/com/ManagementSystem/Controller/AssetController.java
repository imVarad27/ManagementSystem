package com.ManagementSystem.Controller;

import com.ManagementSystem.DTOs.AssetCreationDTO;
import com.ManagementSystem.DTOs.AssetReadDto;
import com.ManagementSystem.DTOs.AssetUpdateDto;
import com.ManagementSystem.Services.AssetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asset")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @PostMapping
    public ResponseEntity<AssetReadDto> createAsset(@Valid @RequestBody AssetCreationDTO asset) {
        AssetReadDto createdAsset = assetService.createAsset(asset);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAsset);
    }

    @GetMapping("/{physicalId}")
    public ResponseEntity<AssetReadDto> getByPhysicalId(@PathVariable String physicalId) {
        return ResponseEntity.ok(assetService.getAssetByPhysicalId(physicalId));
    }

    @GetMapping
    public ResponseEntity<List<AssetReadDto>> getAssets() {
        List<AssetReadDto> assetReadDto = assetService.getAssets();
        return ResponseEntity.ok(assetReadDto);
    }

    @PutMapping
    public ResponseEntity<AssetReadDto> updateAsset(
            @RequestParam String assetId,
            @Valid @RequestBody AssetUpdateDto assetUpdateDto) {
        AssetReadDto updated = assetService.updateAsset(assetId, assetUpdateDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssetById(@PathVariable String id) {
        assetService.deleteByPhysicalId(id);
        return ResponseEntity.noContent().build();
    }
}