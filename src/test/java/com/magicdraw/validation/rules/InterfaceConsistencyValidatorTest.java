package com.magicdraw.validation.rules;

import com.magicdraw.validation.core.ValidationResult;
import com.magicdraw.validation.model.Port;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InterfaceConsistencyValidatorTest {

    private InterfaceConsistencyValidator validator;

    @BeforeEach
    void setUp() {
        validator = new InterfaceConsistencyValidator();
    }

    @Test
    void testValidInterface() {
        Port port = new Port("port1", "DataPort", "Signal", "IN");
        ValidationResult result = validator.validate(port);
        assertTrue(result.isValid());
    }

    @Test
    void testNullElement() {
        ValidationResult result = validator.validate(null);
        assertFalse(result.isValid());
    }

    @Test
    void testPortWithNullType() {
        Port port = new Port("port1", "DataPort", null, "IN");
        ValidationResult result = validator.validate(port);
        assertFalse(result.isValid());
    }

    @Test
    void testPortWithNullDirection() {
        Port port = new Port("port1", "DataPort", "Signal", null);
        ValidationResult result = validator.validate(port);
        assertFalse(result.isValid());
    }
}