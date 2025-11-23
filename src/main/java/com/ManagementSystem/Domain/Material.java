package com.ManagementSystem.Domain;

import com.ManagementSystem.Domain.Converter.PropertyListConverter;
import com.ManagementSystem.Domain.ValueObject.Property;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "materials")
@Getter
@Setter
@NoArgsConstructor
public class Material {

    @Embedded
    @Id
    @Column(name = "material_id", nullable = false, unique = true, updatable = false)
    private String materialId;

    @Embedded
    private String name;

    @Embedded
    private String number;

    @ElementCollection
    private List<String> roles;

    @Convert(converter = PropertyListConverter.class)
    private List<Property> properties;

    @Embedded
    @Column(name = "parent_material_number")
    private String parentMaterialNumber;
}
