# MagicDraw Validation Framework

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)]()
[![Tests](https://img.shields.io/badge/tests-39%20passed-success)]()
[![Java](https://img.shields.io/badge/Java-17-orange)]()
[![JUnit](https://img.shields.io/badge/JUnit-5-blue)]()
[![License](https://img.shields.io/badge/license-MIT-blue)]()

A **Java-based model validation framework** for MagicDraw/Cameo Systems Modeler, implementing automated quality assurance rules for SysML system models. Developed to demonstrate systematic validation practices applicable to aerospace MBSE workflows.

---

## 🎯 Project Overview

This framework provides **automated validation** of SysML model quality, inspired by enterprise-scale MBSE practices from aerospace systems engineering. It implements a modular validator architecture with comprehensive test coverage to ensure model consistency, naming conventions, and traceability requirements.

### Key Features

✅ **10 Production-Ready Validators** - Block naming, requirement traceability, interface consistency, hierarchy depth, value properties, and more  
✅ **39 Comprehensive Unit Tests** - Systematic testing of valid cases, edge conditions, null handling, and error scenarios  
✅ **Type-Safe Domain Model** - Block, Port, Requirement classes with proper encapsulation  
✅ **Structured Validation Reporting** - ERROR/WARNING severity levels with descriptive messages  
✅ **Maven Build Automation** - Clean build pipeline with dependency management  
✅ **Extensible Architecture** - Easy to add new validators following established patterns  

---

## 📊 Build & Test Results
```
[INFO] BUILD SUCCESS
[INFO] Tests run: 39, Failures: 0, Errors: 0, Skipped: 0
[INFO] Total time: 3.223 s
```

**100% test pass rate** - All validators tested against valid inputs, invalid inputs, boundary conditions, and null safety.

---

## 🏗️ Architecture

### Core Components
```
magicdraw-validation-framework/
├── src/main/java/com/magicdraw/validation/
│   ├── core/
│   │   ├── Validator.java              # Validator interface
│   │   ├── ValidationResult.java       # Result with severity levels
│   │   └── ValidationEngine.java       # Orchestration engine
│   ├── model/
│   │   ├── ModelElement.java           # Abstract base class
│   │   ├── Block.java                  # SysML Block representation
│   │   ├── Port.java                   # Interface Port with direction
│   │   └── Requirement.java            # Requirement with traceability
│   └── rules/
│       ├── BlockNamingValidator.java           # Naming conventions
│       ├── RequirementTraceValidator.java      # Traceability checks
│       ├── InterfaceConsistencyValidator.java  # Port validation
│       ├── HierarchyDepthValidator.java        # Model depth limits
│       ├── ValuePropertyValidator.java         # Property format
│       ├── DuplicateIDValidator.java           # Uniqueness checks
│       └── ... (10 validators total)
└── src/test/java/com/magicdraw/validation/
    └── rules/
        ├── BlockNamingValidatorTest.java       # 6 test cases
        ├── RequirementTraceValidatorTest.java  # 5 test cases
        └── ... (10 test classes, 39 tests total)
```

---

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Build & Test
```bash
# Clone the repository
git clone https://github.com/AhemadDaniyal25/magicdraw-validation-framework.git
cd magicdraw-validation-framework

# Run tests
mvn clean test

# Package JAR
mvn package

# Generate documentation
mvn javadoc:javadoc
```

---

## 📝 Validator Examples

### 1. Block Naming Validator
Enforces SysML block naming conventions (UpperCamelCase, alphanumeric only).
```java
Block block = new Block("block1", "UserAuthentication");
ValidationResult result = validator.validate(block);
// Result: PASS - "Block name is valid"

Block invalidBlock = new Block("block2", "user_auth");
ValidationResult result = validator.validate(invalidBlock);
// Result: FAIL - "Block name must start with uppercase letter"
```

### 2. Requirement Traceability Validator
Ensures all requirements have at least one trace relationship.
```java
Requirement req = new Requirement("req1", "User Login");
req.addTraceRelationship("Design-001");
ValidationResult result = validator.validate(req);
// Result: PASS - "Requirement has valid traceability"
```

### 3. Interface Consistency Validator
Validates port types and directions (IN/OUT/INOUT).
```java
Port port = new Port("port1", "DataPort", "Signal", "IN");
ValidationResult result = validator.validate(port);
// Result: PASS - "Port interface is consistent"
```

---

## 🧪 Test Coverage

### Test Strategy
- **Valid Cases**: Correct inputs that should pass validation
- **Invalid Cases**: Incorrect inputs with expected failure messages
- **Edge Cases**: Empty strings, null values, boundary conditions
- **Type Safety**: Incorrect element types, null handling

### Example Test Class
```java
@Test
void testValidBlock() {
    Block block = new Block("block1", "UserBlock");
    ValidationResult result = validator.validate(block);
    assertTrue(result.isValid());
    assertEquals("Block name is valid", result.getMessage());
}

@Test
void testInvalidBlockNaming() {
    Block block = new Block("block1", "userBlock");
    ValidationResult result = validator.validate(block);
    assertFalse(result.isValid());
    assertEquals("Block name must start with uppercase letter", 
                 result.getMessage());
}
```

---

## 📋 Implemented Validators

| Validator | Purpose | Test Cases |
|-----------|---------|------------|
| `BlockNamingValidator` | Validates block naming conventions (UpperCamelCase, alphanumeric) | 6 |
| `RequirementTraceValidator` | Ensures requirements have traceability links | 5 |
| `InterfaceConsistencyValidator` | Validates port types and directions | 4 |
| `HierarchyDepthValidator` | Checks model hierarchy depth limits | 4 |
| `ValuePropertyValidator` | Validates property format (type:unit[]) | 5 |
| `DuplicateIDValidator` | Checks for unique element IDs | 3 |
| `DiagramConsistencyValidator` | Validates diagram element references | 3 |
| `PackageStructureValidator` | Validates package organization | 3 |
| `RelationshipTypeValidator` | Validates relationship types | 3 |
| `ConstraintValidator` | Validates constraint definitions | 3 |

**Total: 39 test cases across 10 validators**

---

## 🎓 Technical Highlights

### Quality Assurance Practices
- **Test-Driven Development**: Systematic unit testing with JUnit 5
- **Separation of Concerns**: Core framework separate from validation rules
- **Fail-Fast Validation**: Early detection of model quality issues
- **Structured Error Reporting**: Severity levels and actionable messages
- **Type Safety**: Strong typing prevents runtime errors

### Design Patterns
- **Strategy Pattern**: Pluggable validators via `Validator` interface
- **Factory Pattern**: `ValidationEngine` orchestrates validators
- **Value Object**: `ValidationResult` encapsulates outcomes
- **Template Method**: Common validation structure in abstract classes

---

## 🔧 Extension Guide

### Adding a New Validator

1. **Implement Validator Interface**
```java
public class MyValidator implements Validator {
    @Override
    public ValidationResult validate(ModelElement element) {
        // Validation logic here
        return new ValidationResult(isValid, message);
    }
    
    @Override
    public String getName() {
        return "MyValidator";
    }
}
```

2. **Create Test Class**
```java
class MyValidatorTest {
    @Test
    void testValidCase() {
        // Test implementation
    }
}
```

3. **Register in ValidationEngine** (if using centralized orchestration)

---

## 🎯 Use Cases

### MBSE Model Quality Assurance
- Automated pre-commit validation of SysML models
- Continuous integration checks for model consistency
- Quality gates for model releases

### Plugin Development
- Foundation for MagicDraw plugin validation modules
- Extensible framework for custom validation rules
- Integration with CI/CD pipelines

### Systems Engineering Workflows
- Requirements verification automation
- Interface consistency checking
- Traceability validation

---

## 📈 Future Enhancements

- [ ] CI/CD integration (GitHub Actions)
- [ ] HTML/PDF validation reports
- [ ] Command-line interface
- [ ] MagicDraw plugin wrapper
- [ ] Configurable validation rules (YAML/JSON)
- [ ] Batch validation for model repositories
- [ ] Integration with DOORS for requirements traceability

---

## 👨‍💻 Author

**Ahemad Daniyal**  
Systems Engineer | MBSE & Quality Assurance  
- 🔗 [LinkedIn](https://www.linkedin.com/in/ahemad-daniyal-532b551a9)
- 📧 Ahemaddaniyal35@gmail.com
- 📍 Erlangen, Germany

### Background
Developed while applying professional MBSE validation practices from Boeing 777-9 systems engineering experience to Java-based tool development. This project demonstrates systematic quality assurance approaches applicable to enterprise MagicDraw plugin development.

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🙏 Acknowledgments

- Inspired by enterprise MBSE validation workflows from aerospace systems engineering
- Built with best practices from professional SysML model quality assurance
- Test-driven development approach following industry standards

---

**⭐ If you find this project useful, please consider giving it a star!**