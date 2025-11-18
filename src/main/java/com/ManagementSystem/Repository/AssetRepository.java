package com.ManagementSystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ManagementSystem.Domain.Asset;

public interface AssetRepository extends JpaRepository<Asset, String> {
    Optional<Asset> findByPhysicalId_Id(String id);
    
}
