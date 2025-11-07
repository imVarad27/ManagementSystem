package com.ManagementSystem.Controller;

import org.springframework.http.ResponseEntity;
import com.ManagementSystem.DTOs.AssetCreationDTO;
import com.ManagementSystem.Domain.Asset;
import com.ManagementSystem.Services.AssetService;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
