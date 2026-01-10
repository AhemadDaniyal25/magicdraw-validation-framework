package com.magicdraw.validation.rules;

import com.magicdraw.validation.core.ValidationResult;
import com.magicdraw.validation.model.TestModelElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiagramConsistencyValidatorTest {

    private DiagramConsistencyValidator validator;

    @BeforeEach
    void setUp() {
        validator = new DiagramConsistencyValidator();
    }

    @Test
    void testValidDiagram() {
        TestModelElement element = new TestModelElement("diagram1", "ClassDiagram");
        ValidationResult result = validator.validate(element);
        assertTrue(result.isValid());
    }

    @Test
    void testNullElement() {
        ValidationResult result = validator.validate(null);
        assertFalse(result.isValid());
        assertEquals("Element cannot be null", result.getMessage());
    }

    @Test
    void testGetName() {
        assertEquals("DiagramConsistencyValidator", validator.getName());
    }
}