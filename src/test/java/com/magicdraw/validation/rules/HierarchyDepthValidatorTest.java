package com.magicdraw.validation.rules;

import com.magicdraw.validation.core.ValidationResult;
import com.magicdraw.validation.model.Block;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HierarchyDepthValidatorTest {

    private HierarchyDepthValidator validator;

    @BeforeEach
    void setUp() {
        validator = new HierarchyDepthValidator();
    }

    @Test
    void testValidHierarchy() {
        Block block = new Block("elem1", "Package", 0);
        ValidationResult result = validator.validate(block);
        assertTrue(result.isValid());
    }

    @Test
    void testNullElement() {
        ValidationResult result = validator.validate(null);
        assertFalse(result.isValid());
    }

    @Test
    void testBlockWithValidDepth() {
        Block block = new Block("block1", "TestBlock", 3);
        ValidationResult result = validator.validate(block);
        assertTrue(result.isValid());
    }

    @Test
    void testGetName() {
        assertEquals("HierarchyDepthValidator", validator.getName());
    }
}