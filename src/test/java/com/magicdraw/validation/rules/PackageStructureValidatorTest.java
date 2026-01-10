package com.magicdraw.validation.rules;

import com.magicdraw.validation.core.ValidationResult;
import com.magicdraw.validation.model.TestModelElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PackageStructureValidatorTest {

    private PackageStructureValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PackageStructureValidator();
    }

    @Test
    void testValidPackage() {
        TestModelElement element = new TestModelElement("pkg1", "com.example");
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
        assertEquals("PackageStructureValidator", validator.getName());
    }
}