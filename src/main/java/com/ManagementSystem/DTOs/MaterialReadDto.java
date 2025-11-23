package com.ManagementSystem.DTOs;

import com.ManagementSystem.Domain.ValueObject.Property;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MaterialReadDto {
    private String name;
    private String number;
    private List<String> roles;
    private List<Property> properties;
    private String parentMaterialNumber;
}
