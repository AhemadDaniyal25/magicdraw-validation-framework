package com.magicdraw.validation.rules;

import com.magicdraw.validation.core.ValidationResult;
import com.magicdraw.validation.core.Validator;
import com.magicdraw.validation.model.ModelElement;
import com.magicdraw.validation.model.Requirement;

public class RequirementTraceValidator implements Validator {
    
    @Override
    public ValidationResult validate(ModelElement element) {
        if (!(element instanceof Requirement)) {
            return new ValidationResult(false, "Element is not a Requirement");
        }
        
        Requirement requirement = (Requirement) element;
        
        if (!requirement.hasTraceability()) {
            return new ValidationResult(false, "Requirement must have at least one trace relationship");
        }
        
        return new ValidationResult(true, "Requirement has valid traceability");
    }
    
    @Override
    public String getName() {
        return "RequirementTraceValidator";
    }
}