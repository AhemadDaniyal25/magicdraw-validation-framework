package com.magicdraw.validation.rules;

import com.magicdraw.validation.core.ValidationResult;
import com.magicdraw.validation.core.Validator;
import com.magicdraw.validation.model.Block;
import com.magicdraw.validation.model.ModelElement;

public class ValuePropertyValidator implements Validator {
    
    @Override
    public ValidationResult validate(ModelElement element) {
        if (!(element instanceof Block)) {
            return new ValidationResult(false, "Element is not a Block");
        }
        
        Block block = (Block) element;
        
        if (block.getProperties().isEmpty()) {
            return new ValidationResult(true, "No properties to validate", "INFO");
        }
        
        for (String property : block.getProperties()) {
            if (property == null || property.isEmpty()) {
                return new ValidationResult(false, "Property cannot be empty");
            }
            
            if (!property.contains(":") || !property.contains("[") || !property.contains("]")) {
                return new ValidationResult(false, 
                    String.format("Property '%s' must have defined type and unit", property));
            }
        }
        
        return new ValidationResult(true, "All properties have defined type and unit");
    }
    
    @Override
    public String getName() {
        return "ValuePropertyValidator";
    }
}