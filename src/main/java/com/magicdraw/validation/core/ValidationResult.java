package com.magicdraw.validation.core;

/**
 * Result of a validation check
 */
public class ValidationResult {
    private final boolean isValid;
    private final String message;
    private final String severity; // ERROR, WARNING, INFO
    
    public ValidationResult(boolean isValid, String message) {
        this(isValid, message, isValid ? "INFO" : "ERROR");
    }
    
    public ValidationResult(boolean isValid, String message, String severity) {
        this.isValid = isValid;
        this.message = message;
        this.severity = severity;
    }
    
    public boolean isValid() {
        return isValid;
    }
    
    public String getMessage() {
        return message;
    }
    
    public String getSeverity() {
        return severity;
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s: %s", severity, isValid ? "PASS" : "FAIL", message);
    }
}