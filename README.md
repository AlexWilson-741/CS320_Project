##README
# Software Testing and Quality Assurance Portfolio

This repository contains selected work demonstrating my ability to implement validation logic, develop automated unit tests, and apply structured testing strategies to ensure software quality.

## Included Files

### Project One: Contact Service
- `Contact.java`
- `ContactService.java`
- `ContactTest.java`
- `ContactServiceTest.java`

These files demonstrate object validation, service-layer logic, and automated unit testing to verify requirements and uncover edge case failures.

### Project Two: Summary and Reflections Report

This report analyzes testing strategies, automation practices, and quality assurance principles applied throughout development.

---

# Reflection

## How can I ensure that my code, program, or software is functional and secure?
Making sure your software is functional and secure begins with enforcing requirements at the code level. In the Contact Service project, I implemented validation rules inside the constructor that were tailored to the requirements specified. This included null checks and length limitations for fields such as contact ID and phone number. By embedding constraints directly into the model, I reduced the risk of inconsistent or unsafe data entering the system. I also employed unit testing to verify both expected behavior and failure conditions. Writing tests that attempted to break validation rules confirmed that constraints were working as intended. This enhances security by minimizing undefined behavior and reducing the vunerabilities created by unchecked inputs. Together, defensive programming and automated testing form a layered strategy that improves reliability and increases confidence in system integrity.

## How do I interpret user needs and incorporate them into a program?
Interpreting user needs requires translating informal requirements into precise, testable constraints. In this project, the requirements specified maximum field lengths, uniqueness constraints, and update behaviors. I converted these into validation rules and service-layer logic. I mapped each requirement directly a constraint within the code and verified that constraint using unit tests. This ensured traceability between requirements and implementation. If a requirement changed, I could immediately identify the affected logic and corresponding tests. Incorporating user needs also requires anticipating misuse. By testing invalid inputs and boundary conditions, I accounted for realistic user error rather than assuming expected inputs.

## How do I approach designing software?
I approach software design incrementally and structurally. First, I define the domain objects and their invariants. In this case, the Contact class represented the core entity, so its internal validity rules were established before building service logic. I prefer to implement functionality in small increments and then create the corresponding tests for each addition. This allows me to validate behavior step by step and prevent defects from compounding. Second, I separate responsibilities. The model enforces state validity, and the service layer manages collections and business rules such as uniqueness and update operations. Finally, I design tests alongside or immediately after implementation. Writing unit tests forces me to think in terms of observable behavior and edge cases, as well as what inputs could break the software. This mindset helps expose weaknesses early and encourages modular, loosely coupled code.
