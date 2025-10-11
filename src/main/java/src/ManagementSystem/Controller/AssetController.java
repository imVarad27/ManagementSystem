package src.ManagementSystem.Controller;

import src.ManagementSystem.DTOs.AssetCreationDTO;
import src.ManagementSystem.Services.AssetService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
    public String PostAsset(@Valid @RequestBody AssetCreationDTO assetCreationDTO){
        assetService.createAsset(assetCreationDTO);
        return "Asset saved successfully";
    }

}
