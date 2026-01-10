package com.magicdraw.validation.rules;

import com.magicdraw.validation.core.ValidationResult;
import com.magicdraw.validation.core.Validator;
import com.magicdraw.validation.model.ModelElement;

public class RelationshipTypeValidator implements Validator {
    
    @Override
    public ValidationResult validate(ModelElement element) {
        if (element == null) {
            return new ValidationResult(false, "Element cannot be null");
        }
        
        String type = element.getType();
        if (type == null || type.isEmpty()) {
            return new ValidationResult(false, "Element type cannot be empty");
        }
        
        return new ValidationResult(true, "Relationship type is valid");
    }
    
    @Override
    public String getName() {
        return "RelationshipTypeValidator";
    }
}