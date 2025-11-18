package com.ManagementSystem.DTOs;

import java.time.Instant;
import java.util.List;

public record ApiError( int status,
    String error,
    String message,
    String code,
    Instant timeStamp,
    String path,
    List<ValidationError> details,
    String traceId) {
   
        public ApiError(int status, String error, String message, String code,List<ValidationError> details, String path,String traceId){
            this(status,error,message,code,Instant.now(),path,details,traceId);
        }

     

        public static ApiError validation(List<ValidationError> ValidationErrors,String path,String id){
        return new ApiError(
        400,
        "Bad Request",
        "Validation failed",
        null,
        Instant.now(),
        path,
        ValidationErrors,
        null
    );
        }
}
