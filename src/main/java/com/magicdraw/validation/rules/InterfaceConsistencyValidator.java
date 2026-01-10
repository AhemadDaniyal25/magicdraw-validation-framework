package com.magicdraw.validation.rules;

import com.magicdraw.validation.core.ValidationResult;
import com.magicdraw.validation.core.Validator;
import com.magicdraw.validation.model.ModelElement;
import com.magicdraw.validation.model.Port;

public class InterfaceConsistencyValidator implements Validator {
    
    @Override
    public ValidationResult validate(ModelElement element) {
        if (!(element instanceof Port)) {
            return new ValidationResult(false, "Element is not a Port");
        }
        
        Port port = (Port) element;
        
        if (port.getPortType() == null || port.getPortType().isEmpty()) {
            return new ValidationResult(false, "Port type cannot be empty");
        }
        
        if (port.getDirection() == null || port.getDirection().isEmpty()) {
            return new ValidationResult(false, "Port direction cannot be empty");
        }
        
        String direction = port.getDirection().toUpperCase();
        if (!direction.equals("IN") && !direction.equals("OUT") && !direction.equals("INOUT")) {
            return new ValidationResult(false, "Port direction must be IN, OUT, or INOUT");
        }
        
        return new ValidationResult(true, "Port interface is consistent");
    }
    
    @Override
    public String getName() {
        return "InterfaceConsistencyValidator";
    }
}