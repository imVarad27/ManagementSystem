package com.ManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ManagementSystem.Domain.Asset;

public interface AssetRepository extends JpaRepository<Asset, String> {
    Asset findByPhysicalId_Id(String id);
}
