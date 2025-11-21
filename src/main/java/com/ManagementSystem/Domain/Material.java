package com.ManagementSystem.Domain;

import com.ManagementSystem.Domain.Converter.PropertyListConverter;
import com.ManagementSystem.Domain.ValueObject.Property;
import jakarta.persistence.Convert;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;

import java.util.List;

public class Material {

    @Embedded
    private String name;

    @Embedded
    private String number;

    @ElementCollection
    private List<String> roles;

    @Convert(converter = PropertyListConverter.class)
    private List<Property> properties;

    @Embedded
    private String parentMaterialNumber;
}
