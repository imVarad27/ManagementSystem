package src.ManagementSystem.Domain.ValueObject;

import lombok.Getter;
import src.ManagementSystem.Domain.Enums.PropertyDataType;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.lang.Integer.parseInt;

@Getter
public class Property {
    private final String name;
    private final PropertyDataType dataType;
    private final String value;
    private final String originalValue;
    private final String minimumValue;
    private final String displayName;
    private final List<String> possibleOptions;
    private final String unit;

    private final boolean isSubTypeLevel;
    private final boolean isCore;
    private final boolean isPhysical;
    private final boolean isDynamic;
    private final boolean isMandatory;

    public Property(
            String name,
            PropertyDataType dataType,
            String value,
            String originalValue,
            String minimumValue,
            String displayName,
            List<String> possibleOptions,
            String unit,
            boolean isSubTypeLevel,
            boolean isCore,
            boolean isPhysical,
            boolean isDynamic,
            boolean isMandatory) {

        this.name = Objects.requireNonNull(name, "name must not be null");
        this.dataType = Objects.requireNonNull(dataType, "dataType must not be null");
        this.value = isDynamic ? value : originalValue;
        this.originalValue = originalValue;
        this.minimumValue = minimumValue;
        this.displayName = displayName;
        this.possibleOptions = possibleOptions == null
                ? Collections.emptyList()
                : List.copyOf(possibleOptions);
        this.unit = unit;

        this.isSubTypeLevel = isSubTypeLevel;
        this.isCore = isCore;
        this.isPhysical = isPhysical;
        this.isDynamic = isDynamic;
        this.isMandatory = isMandatory;
    }

    private void validateValue(String val) {
        if (val == null) return;

        switch (dataType) {
            case Integer:
                parseInt(val);
                break;
            case Double:
                parseDouble(val);
                break;
            case String:
                break;
            default:
                throw new AssertionError("Unexpected PropertyDataType: " + dataType);
        }
    }

    private static int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Field '" + "value" + "' must be an Integer but was '" + s + "'");
        }
    }

    private static double parseDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Field '" + "value" + "' must be a Double but was '" + s + "'");
        }
    }
}
