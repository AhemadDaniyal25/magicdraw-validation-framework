package com.magicdraw.validation.rules;

import com.magicdraw.validation.core.ValidationResult;
import com.magicdraw.validation.core.Validator;
import com.magicdraw.validation.model.ModelElement;

public class ConstraintValidator implements Validator {
    
    @Override
    public ValidationResult validate(ModelElement element) {
        if (element == null) {
            return new ValidationResult(false, "Element cannot be null");
        }
        
        if (element.getId() == null || element.getName() == null) {
            return new ValidationResult(false, "Element must have valid ID and name");
        }
        
        return new ValidationResult(true, "Constraint is valid");
    }
    
    @Override
    public String getName() {
        return "ConstraintValidator";
    }
}