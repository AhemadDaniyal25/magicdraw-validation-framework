package com.magicdraw.validation.rules;

import com.magicdraw.validation.core.ValidationResult;
import com.magicdraw.validation.core.Validator;
import com.magicdraw.validation.model.ModelElement;

public class DiagramConsistencyValidator implements Validator {
    
    @Override
    public ValidationResult validate(ModelElement element) {
        if (element == null) {
            return new ValidationResult(false, "Element cannot be null");
        }
        
        if (element.getId() == null || element.getId().isEmpty()) {
            return new ValidationResult(false, "Element must have valid ID for diagram reference");
        }
        
        return new ValidationResult(true, "Diagram element is consistent with model");
    }
    
    @Override
    public String getName() {
        return "DiagramConsistencyValidator";
    }
}