# MagicDraw Validation Framework

A Java-based validation framework for automated MagicDraw/Cameo Systems Modeler quality assurance, implementing systematic validation rules for SysML model consistency, requirement traceability, and MBSE compliance checks.

## Purpose

This project demonstrates quality assurance practices for Model-Based Systems Engineering (MBSE) tools, focusing on automated validation patterns commonly used in MagicDraw plugin development. Built to understand plugin-level validation workflows and systematic testing approaches for engineering tool QA.

**Background:** Inspired by professional experience performing model quality validation on Boeing 777-9 SysML models in MagicDraw, this framework implements common validation patterns in Java with comprehensive JUnit test coverage.

## Overview

MagicDraw plugins often need to validate models to ensure:
- Compliance with modeling standards and conventions
- Consistency across model elements and relationships  
- Completeness of requirements traceability
- Quality of system decomposition and interfaces

This framework implements these validation patterns with:
- ✅ **Clear validation rules** with explicit pass/fail criteria
- ✅ **Comprehensive JUnit tests** ensuring validation correctness
- ✅ **Structured error reporting** for engineering users
- ✅ **Extensible architecture** for adding new validation rules

## Validation Rules

The framework implements **10 core validation rules** based on real MBSE quality requirements:

### 1. Block Naming Convention Validator
**Rule:** Block names must follow PascalCase convention (start with uppercase, no special characters)  
**Rationale:** Ensures consistent naming across large system models  
**Examples:**
- ✅ `PowerDistributionSystem`
- ✅ `FlightControlModule`  
- ❌ `power_system` (underscore)
- ❌ `flightControl` (lowercase start)

### 2. Requirement Traceability Validator
**Rule:** All requirements must have at least one satisfy, derive, or refine relationship  
**Rationale:** Ensures traceability between requirements and design elements  
**Examples:**
- ✅ Requirement with `<<satisfy>>` to Block
- ✅ Requirement with `<<refine>>` to parent Requirement
- ❌ Orphaned requirement with no trace relationships

### 3. Interface Consistency Validator
**Rule:** Connected ports must have compatible types and flow directions  
**Rationale:** Prevents interface mismatches in system integration  
**Examples:**
- ✅ Electrical output port → Electrical input port
- ❌ Hydraulic port → Electrical port (type mismatch)
- ❌ Output port → Output port (direction conflict)

### 4. Model Hierarchy Depth Validator
**Rule:** System decomposition should not exceed 6 levels deep  
**Rationale:** Prevents overly complex models that are difficult to navigate and maintain  
**Examples:**
- ✅ System → Subsystem → Component → Part → SubPart → Element (level 6)
- ❌ Exceeding 6 levels indicates over-decomposition

### 5. Value Property Completeness Validator
**Rule:** Value properties must have defined type and unit  
**Rationale:** Ensures properties are properly specified for parametric analysis  
**Examples:**
- ✅ `mass: Real [kg]`
- ✅ `voltage: Real [V]`
- ❌ `mass` (missing type and unit)
- ❌ `mass: Real` (missing unit)

### 6. Relationship Type Validator
**Rule:** Only valid SysML relationship types allowed between element pairs  
**Rationale:** Enforces SysML metamodel constraints  
**Examples:**
- ✅ Block `--composition-->` Block
- ✅ Requirement `--satisfy-->` Block
- ❌ Block `--satisfy-->` Block (invalid relationship type)

### 7. Duplicate Element ID Validator
**Rule:** No duplicate element IDs or names within the same package  
**Rationale:** Prevents ambiguity and ensures unique identification  
**Examples:**
- ✅ Unique block names: `Motor_Primary`, `Motor_Secondary`
- ❌ Two blocks named `Motor` in same package

### 8. Constraint Expression Validator
**Rule:** Constraint expressions must use valid OCL/math syntax  
**Rationale:** Ensures constraints can be evaluated by analysis tools  
**Examples:**
- ✅ `{mass > 0 AND mass < 1000}`
- ✅ `{voltage == 12 OR voltage == 24}`
- ❌ `{mass > }` (incomplete expression)
- ❌ `{mass >> 0}` (invalid operator)

### 9. Diagram Element Consistency Validator
**Rule:** Elements shown in diagrams must exist in the model repository  
**Rationale:** Prevents broken references and orphaned diagram elements  
**Examples:**
- ✅ Block in BDD exists in model browser
- ❌ Diagram shows deleted element (broken reference)

### 10. Package Structure Validator
**Rule:** Model packages should follow organizational hierarchy (max 50 elements per package)  
**Rationale:** Ensures maintainable model organization  
**Examples:**
- ✅ Logical grouping: `Systems/Electrical/Components`
- ❌ Root package with 200+ elements (flat structure)

## Architecture

### Project Structure
