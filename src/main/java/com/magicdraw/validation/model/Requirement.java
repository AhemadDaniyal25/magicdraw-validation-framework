package com.magicdraw.validation.model;

import java.util.ArrayList;
import java.util.List;

public class Requirement extends ModelElement {
    private List<String> traceRelationships;
    private String text;
    
    public Requirement(String id, String name) {
        super(id, name);
        this.traceRelationships = new ArrayList<>();
    }
    
    public Requirement(String id, String name, String text) {
        super(id, name);
        this.text = text;
        this.traceRelationships = new ArrayList<>();
    }
    
    @Override
    public String getType() {
        return "Requirement";
    }
    
    public List<String> getTraceRelationships() {
        return traceRelationships;
    }
    
    public void addTraceRelationship(String relationship) {
        this.traceRelationships.add(relationship);
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public boolean hasTraceability() {
        return !traceRelationships.isEmpty();
    }
}