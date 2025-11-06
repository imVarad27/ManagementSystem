package src.ManagementSystem.Domain.ValueObject;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.NoArgsConstructor;
import src.ManagementSystem.Domain.ValueObject.Constants.LifeStageConstants;

import java.util.List;

@Getter
@Embeddable
@NoArgsConstructor
public class LifeStage {
    private String stage;

    @Embedded
    private InventoryStatus inventoryStatus;

    public LifeStage(String stage, InventoryStatus inventoryStatus) {
        this.stage = stage;
        this.inventoryStatus = inventoryStatus;
    }

    public static LifeStage prepared() {
        return new LifeStage(LifeStageConstants.PREPARED,
                new InventoryStatus("Not Ready To Use"));
    }

    public static LifeStage available() {
        return new LifeStage(LifeStageConstants.AVAILABLE,
                new InventoryStatus("Ready To Use"));
    }

    public static LifeStage inAssembly() {
        return new LifeStage(LifeStageConstants.IN_ASSEMBLY,
                new InventoryStatus("Ready To Use"));
    }

    public static LifeStage activelyProducing() {
        return new LifeStage(LifeStageConstants.ACTIVELY_PRODUCING,
                new InventoryStatus("In Use"));
    }

    public static LifeStage mountedOnMachine() {
        return new LifeStage(LifeStageConstants.MOUNTED_ON_MACHINE,
                new InventoryStatus("In Use"));
    }

    public static LifeStage needsReconditioning() {
        return new LifeStage(LifeStageConstants.NEEDS_RECONDITIONING,
                new InventoryStatus("Temporary Unavailable"));
    }

    public static LifeStage outForReconditioning() {
        return new LifeStage(LifeStageConstants.OUT_FOR_RECONDITIONING,
                new InventoryStatus("Temporary Unavailable"));
    }

    public static LifeStage needsAttention() {
        return new LifeStage(LifeStageConstants.NEEDS_ATTENTION,
                new InventoryStatus("Temporary Unavailable"));
    }

    public static LifeStage retire() {
        return new LifeStage(LifeStageConstants.RETIRE,
                new InventoryStatus("Decommissioned"));
    }

    // "Common" set
    public static List<LifeStage> common() {
        return List.of(available(), needsAttention(), retire());
    }
}
