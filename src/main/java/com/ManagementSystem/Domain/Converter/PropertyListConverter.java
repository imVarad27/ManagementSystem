package com.ManagementSystem.Domain.Converter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.ManagementSystem.Domain.ValueObject.Property;
import java.util.List;

@Converter
public class PropertyListConverter implements AttributeConverter<List<Property>, String> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<Property> properties) {
        try {
            return properties == null ? "[]" : objectMapper.writeValueAsString(properties);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert properties to JSON", e);
        }
    }

    @Override
    public List<Property> convertToEntityAttribute(String dbData) {
        try {
            return dbData == null ? List.of() :
                    objectMapper.readValue(dbData, new TypeReference<>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert JSON to properties list", e);
        }
    }
}
