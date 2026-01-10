package com.magicdraw.validation.rules;

import com.magicdraw.validation.core.ValidationResult;
import com.magicdraw.validation.core.Validator;
import com.magicdraw.validation.model.ModelElement;

public class PackageStructureValidator implements Validator {
    
    @Override
    public ValidationResult validate(ModelElement element) {
        if (element == null) {
            return new ValidationResult(false, "Element cannot be null");
        }
        
        String name = element.getName();
        if (name == null || name.isEmpty()) {
            return new ValidationResult(false, "Package element must have valid name");
        }
        
        return new ValidationResult(true, "Package structure is valid");
    }
    
    @Override
    public String getName() {
        return "PackageStructureValidator";
    }
}