package com.magicdraw.validation.model;

public class Port extends ModelElement {
    private String portType;
    private String direction;
    
    public Port(String id, String name, String portType, String direction) {
        super(id, name);
        this.portType = portType;
        this.direction = direction;
    }
    
    @Override
    public String getType() {
        return "Port";
    }
    
    public String getPortType() {
        return portType;
    }
    
    public void setPortType(String portType) {
        this.portType = portType;
    }
    
    public String getDirection() {
        return direction;
    }
    
    public void setDirection(String direction) {
        this.direction = direction;
    }
    
    public boolean isCompatibleWith(Port other) {
        if (other == null) return false;
        return this.portType.equals(other.portType) && 
               !this.direction.equals(other.direction);
    }
}