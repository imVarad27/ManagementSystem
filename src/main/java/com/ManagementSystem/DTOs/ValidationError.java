package com.ManagementSystem.DTOs;

public record ValidationError(
    String field,
    String rejectedValue,
    String message
) {
    public static ValidationError of(String field, String rejectedValue, String message){
        return new ValidationError(field, rejectedValue==null?null:String.valueOf(rejectedValue), message);
    }
}
