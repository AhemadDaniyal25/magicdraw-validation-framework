package com.magicdraw.validation.core;

import com.magicdraw.validation.model.ModelElement;

/**
 * Base validator interface for model validation rules
 */
public interface Validator {
    /**
     * Validates a model element
     * @param element The model element to validate
     * @return Validation result with pass/fail status and message
     */
    ValidationResult validate(ModelElement element);
    
    /**
     * Gets the name of this validator
     * @return Validator name
     */
    String getName();
}