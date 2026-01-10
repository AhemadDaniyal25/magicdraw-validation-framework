package com.magicdraw.validation.rules;

import com.magicdraw.validation.core.ValidationResult;
import com.magicdraw.validation.model.Block;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValuePropertyValidatorTest {

    private ValuePropertyValidator validator;

    @BeforeEach
    void setUp() {
        validator = new ValuePropertyValidator();
    }

    @Test
    void testValidValue() {
        Block block = new Block("value1", "PriceBlock");
        block.addProperty("price:double[USD]");
        ValidationResult result = validator.validate(block);
        assertTrue(result.isValid());
        assertEquals("All properties have defined type and unit", result.getMessage());
    }

    @Test
    void testNullElement() {
        ValidationResult result = validator.validate(null);
        assertFalse(result.isValid());
    }

    @Test
    void testBlockWithEmptyProperties() {
        Block block = new Block("value1", "EmptyBlock");
        ValidationResult result = validator.validate(block);
        assertTrue(result.isValid());
        assertEquals("No properties to validate", result.getMessage());
    }

    @Test
    void testBlockWithInvalidProperty() {
        Block block = new Block("value1", "InvalidBlock");
        block.addProperty("price");
        ValidationResult result = validator.validate(block);
        assertFalse(result.isValid());
        assertTrue(result.getMessage().contains("must have defined type and unit"));
    }

    @Test
    void testGetName() {
        assertEquals("ValuePropertyValidator", validator.getName());
    }
}