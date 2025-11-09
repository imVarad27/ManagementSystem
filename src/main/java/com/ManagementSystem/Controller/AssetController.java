package com.ManagementSystem.Controller;

import com.ManagementSystem.DTOs.AssetReadDto;
import org.springframework.http.ResponseEntity;
import com.ManagementSystem.DTOs.AssetCreationDTO;
import com.ManagementSystem.Domain.Asset;
import com.ManagementSystem.Services.AssetService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/asset")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @PostMapping
    public ResponseEntity<?> createAsset(@Valid @RequestBody AssetCreationDTO asset) {

            Asset createdAsset = assetService.createAsset(asset);
            return ResponseEntity.ok(createdAsset);
    }

    @GetMapping
    public List<AssetReadDto> getAllAssets(){
        return assetService.getAssets();
    }

}
