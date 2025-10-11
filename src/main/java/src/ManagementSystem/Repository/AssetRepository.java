package src.ManagementSystem.Repository;

import src.ManagementSystem.Domain.Asset;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssetRepository extends MongoRepository<Asset, String> {
}
