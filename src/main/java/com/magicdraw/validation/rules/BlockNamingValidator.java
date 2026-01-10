package com.magicdraw.validation.rules;

import com.magicdraw.validation.core.ValidationResult;
import com.magicdraw.validation.core.Validator;
import com.magicdraw.validation.model.Block;
import com.magicdraw.validation.model.ModelElement;

public class BlockNamingValidator implements Validator {
    
    @Override
    public ValidationResult validate(ModelElement element) {
        if (!(element instanceof Block)) {
            return new ValidationResult(false, "Element is not a Block");
        }
        
        Block block = (Block) element;
        String name = block.getName();
        
        if (name == null || name.isEmpty()) {
            return new ValidationResult(false, "Block name cannot be empty");
        }
        
        if (!Character.isUpperCase(name.charAt(0))) {
            return new ValidationResult(false, "Block name must start with uppercase letter");
        }
        
        if (!name.matches("^[A-Z][a-zA-Z0-9]*$")) {
            return new ValidationResult(false, "Block name must contain only alphanumeric characters");
        }
        
        return new ValidationResult(true, "Block name is valid");
    }
    
    @Override
    public String getName() {
        return "BlockNamingValidator";
    }
}