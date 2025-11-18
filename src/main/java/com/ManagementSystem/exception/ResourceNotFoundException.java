package com.ManagementSystem.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {
   private static final long serialVersionUID = 1L;
    private final String resource;
    private final String field;
    private final String id;




   public ResourceNotFoundException(String resource,String field,Object id){
        super(String.format("%s not found with %s : %s",resource,field,String.valueOf(id)));
        this.resource = resource;
        this.id = id == null ? null  : String.valueOf(id);
         this.field = field;
   }

   public ResourceNotFoundException(String resource) {
        super(resource + " not found");
        this.resource = resource;
        this.field = null;
        this.id = null;
    }

     public ResourceNotFoundException(String resource, Object id) {
        this(resource, "id", id);
    }


}
