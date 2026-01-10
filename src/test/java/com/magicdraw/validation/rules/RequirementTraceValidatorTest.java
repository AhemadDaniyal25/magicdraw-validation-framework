package com.magicdraw.validation.rules;

import com.magicdraw.validation.core.ValidationResult;
import com.magicdraw.validation.model.Requirement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RequirementTraceValidatorTest {

    private RequirementTraceValidator validator;

    @BeforeEach
    void setUp() {
        validator = new RequirementTraceValidator();
    }

    @Test
    void testValidRequirement() {
        Requirement req = new Requirement("req1", "User Authentication");
        req.addTraceRelationship("Design-001");
        ValidationResult result = validator.validate(req);
        assertTrue(result.isValid());
    }

    @Test
    void testNullElement() {
        ValidationResult result = validator.validate(null);
        assertFalse(result.isValid());
    }

    @Test
    void testRequirementWithoutTrace() {
        Requirement req = new Requirement("req1", "User Authentication");
        ValidationResult result = validator.validate(req);
        assertFalse(result.isValid());
        assertEquals("Requirement must have at least one trace relationship", result.getMessage());
    }

    @Test
    void testRequirementWithMultipleTraces() {
        Requirement req = new Requirement("req2", "Data Encryption");
        req.addTraceRelationship("Design-001");
        req.addTraceRelationship("Design-002");
        ValidationResult result = validator.validate(req);
        assertTrue(result.isValid());
    }

    @Test
    void testGetName() {
        assertEquals("RequirementTraceValidator", validator.getName());
    }
}