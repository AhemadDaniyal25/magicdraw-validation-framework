package com.magicdraw.validation.rules;

import com.magicdraw.validation.core.ValidationResult;
import com.magicdraw.validation.core.Validator;
import com.magicdraw.validation.model.Block;
import com.magicdraw.validation.model.ModelElement;

public class HierarchyDepthValidator implements Validator {
    private static final int MAX_DEPTH = 6;
    
    @Override
    public ValidationResult validate(ModelElement element) {
        if (!(element instanceof Block)) {
            return new ValidationResult(false, "Element is not a Block");
        }
        
        Block block = (Block) element;
        
        if (block.getHierarchyLevel() > MAX_DEPTH) {
            return new ValidationResult(false, 
                String.format("Hierarchy depth %d exceeds maximum allowed depth of %d", 
                    block.getHierarchyLevel(), MAX_DEPTH));
        }
        
        return new ValidationResult(true, "Hierarchy depth is within limits");
    }
    
    @Override
    public String getName() {
        return "HierarchyDepthValidator";
    }
}