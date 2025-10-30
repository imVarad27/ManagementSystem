package src.ManagementSystem.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import src.ManagementSystem.DTOs.AssetCreationDTO;
import src.ManagementSystem.Domain.Asset;
import src.ManagementSystem.Services.AssetService;
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
    public ResponseEntity<?> createAsset(@Valid @RequestBody AssetCreationDTO asset,
                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation failed");
        }

        try {
            Asset createdAsset = assetService.createAsset(asset);
            return ResponseEntity.ok(createdAsset);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating asset: " + e.getMessage());
        }
    }

}
