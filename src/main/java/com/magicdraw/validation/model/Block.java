package com.magicdraw.validation.model;

import java.util.ArrayList;
import java.util.List;

public class Block extends ModelElement {
    private int hierarchyLevel;
    private List<String> properties;
    private List<String> ports;
    
    public Block(String id, String name) {
        super(id, name);
        this.hierarchyLevel = 0;
        this.properties = new ArrayList<>();
        this.ports = new ArrayList<>();
    }
    
    public Block(String id, String name, int hierarchyLevel) {
        super(id, name);
        this.hierarchyLevel = hierarchyLevel;
        this.properties = new ArrayList<>();
        this.ports = new ArrayList<>();
    }
    
    @Override
    public String getType() {
        return "Block";
    }
    
    public int getHierarchyLevel() {
        return hierarchyLevel;
    }
    
    public void setHierarchyLevel(int hierarchyLevel) {
        this.hierarchyLevel = hierarchyLevel;
    }
    
    public List<String> getProperties() {
        return properties;
    }
    
    public void addProperty(String property) {
        this.properties.add(property);
    }
    
    public List<String> getPorts() {
        return ports;
    }
    
    public void addPort(String port) {
        this.ports.add(port);
    }
}