package com.magicdraw.validation.rules;

import com.magicdraw.validation.core.ValidationResult;
import com.magicdraw.validation.core.Validator;
import com.magicdraw.validation.model.ModelElement;

public class DuplicateIDValidator implements Validator {
    
    @Override
    public ValidationResult validate(ModelElement element) {
        if (element == null) {
            return new ValidationResult(false, "Element cannot be null");
        }
        
        String id = element.getId();
        if (id == null || id.isEmpty()) {
            return new ValidationResult(false, "Element ID cannot be empty");
        }
        
        String name = element.getName();
        if (name == null || name.isEmpty()) {
            return new ValidationResult(false, "Element name cannot be empty");
        }
        
        return new ValidationResult(true, "Element has valid unique ID and name");
    }
    
    @Override
    public String getName() {
        return "DuplicateIDValidator";
    }
}