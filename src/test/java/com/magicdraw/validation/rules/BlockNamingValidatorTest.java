package com.magicdraw.validation.rules;

import com.magicdraw.validation.core.ValidationResult;
import com.magicdraw.validation.model.Block;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BlockNamingValidatorTest {

    private BlockNamingValidator validator;

    @BeforeEach
    void setUp() {
        validator = new BlockNamingValidator();
    }

    @Test
    void testValidBlock() {
        Block block = new Block("block1", "UserBlock");
        ValidationResult result = validator.validate(block);
        assertTrue(result.isValid());
    }

    @Test
    void testNullElement() {
        ValidationResult result = validator.validate(null);
        assertFalse(result.isValid());
    }

    @Test
    void testGetName() {
        assertEquals("BlockNamingValidator", validator.getName());
    }

    @Test
    void testEmptyName() {
        Block block = new Block("block1", "");
        ValidationResult result = validator.validate(block);
        assertFalse(result.isValid());
    }

    @Test
    void testNullName() {
        Block block = new Block("block1", null);
        ValidationResult result = validator.validate(block);
        assertFalse(result.isValid());
    }

    @Test
    void testValidNameFormat() {
        Block block = new Block("block1", "MyBlock");
        ValidationResult result = validator.validate(block);
        assertTrue(result.isValid());
    }
}