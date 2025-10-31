package src.ManagementSystem.Repository;

import src.ManagementSystem.Domain.Asset;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AssetRepository extends MongoRepository<Asset, String> {
    Optional<Asset> findByAssetId(String s);
}
