package src.ManagementSystem.Domain.ValueObject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import src.ManagementSystem.Domain.Enums.PropertyDataType;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    @JsonCreator
    public Property(
            @JsonProperty("name") String name,
            @JsonProperty("dataType") PropertyDataType dataType,
            @JsonProperty("value") String value,
            @JsonProperty("originalValue") String originalValue,
            @JsonProperty("minimumValue") String minimumValue,
            @JsonProperty("displayName") String displayName,
            @JsonProperty("possibleOptions") List<String> possibleOptions,
            @JsonProperty("unit") String unit,
            @JsonProperty("subTypeLevel") boolean isSubTypeLevel,
            @JsonProperty("core") boolean isCore,
            @JsonProperty("physical") boolean isPhysical,
            @JsonProperty("dynamic") boolean isDynamic,
            @JsonProperty("mandatory") boolean isMandatory
    ) {
        this.name = name;
        this.dataType = dataType;
        this.value = isDynamic ? value : originalValue;
        this.originalValue = originalValue;
        this.minimumValue = minimumValue;
        this.displayName = displayName;
        this.possibleOptions = possibleOptions == null ? List.of() : List.copyOf(possibleOptions);
        this.unit = unit;
        this.isSubTypeLevel = isSubTypeLevel;
        this.isCore = isCore;
        this.isPhysical = isPhysical;
        this.isDynamic = isDynamic;
        this.isMandatory = isMandatory;
    }

    public static void validateProperty(Property property) {
        Objects.requireNonNull(property, "Property must not be null");
        Objects.requireNonNull(property.getName(), "Property name must not be null");
        Objects.requireNonNull(property.getDataType(), "Property dataType must not be null");

        if (property.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Property name must not be empty");
        }
        String valueToValidate = property.isDynamic() ? property.getValue() : property.getOriginalValue();
        if (valueToValidate != null) {
            property.validateValue(valueToValidate);
        }
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

    private static void parseInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Field '" + "value" + "' must be an Integer but was '" + s + "'");
        }
    }

    private static void parseDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Field '" + "value" + "' must be a Double but was '" + s + "'");
        }
    }
}
