package com.magicdraw.validation.model;

/**
 * Base class for model elements
 */
public abstract class ModelElement {
    protected String id;
    protected String name;
    
    public ModelElement(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public abstract String getType();
}