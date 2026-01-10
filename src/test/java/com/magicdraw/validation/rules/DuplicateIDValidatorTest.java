package com.magicdraw.validation.rules;

import com.magicdraw.validation.core.ValidationResult;
import com.magicdraw.validation.model.TestModelElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DuplicateIDValidatorTest {

    private DuplicateIDValidator validator;

    @BeforeEach
    void setUp() {
        validator = new DuplicateIDValidator();
    }

    @Test
    void testValidElement() {
        TestModelElement element = new TestModelElement("unique1", "Element");
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
        assertEquals("DuplicateIDValidator", validator.getName());
    }
}