package com.magicdraw.validation.model;

public class TestModelElement extends ModelElement {
    
    private String type;
    
    public TestModelElement(String id, String name) {
        super(id, name);
        this.type = "TestType";
    }
    
    public TestModelElement(String id, String name, String type) {
        super(id, name);
        this.type = type;
    }
    
    @Override
    public String getType() {
        return type;
    }
}