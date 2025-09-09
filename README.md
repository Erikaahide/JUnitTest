[![CI - Maven Test](https://github.com/Erikaahide/JUnitTest/actions/workflows/maven.yml/badge.svg)](https://github.com/Erikaahide/JUnitTest/actions/workflows/maven.yml)

# JUnit Demo: Unit, Mockito & MockMvc (Spring Boot 3 / Java 21)

Small project to demonstrate:
- **JUnit 5**: `@Test`, `@DisplayName`, `@Disabled`, `@BeforeEach`, `@AfterEach`, assertions, `@ParameterizedTest`.
- **Mockito**: `@Mock`, `@InjectMocks`, `when/then`, `verify`.
- **Spring MVC Test**: `@WebMvcTest`, `MockMvc` for REST endpoints.

## Requirements
- Java 21
- Maven 3.9+

## Run Tests Locally
```bash
./mvnw test
# or
mvn test
```

This repository includes a GitHub Actions workflow (.github/workflows/maven.yml) that runs automatically:

- Triggers:
On every push to any branch  
On every pull_request  
- Environment:
Ubuntu runner  
Java 21 (Temurin distribution)  
Maven cache enabled for faster builds  
- Steps:
Check out the repository  
Set up Java  
Run mvn test  
Upload test reports (target/surefire-reports) as build artifacts  
- Badge:
The badge at the top of this README reflects the latest workflow status.  
Green = all tests passing  
Red = some tests failed  

Ensures that every commit and pull request is tested automatically.  
Provides confidence that the codebase is stable and the examples work.  
Demonstrates professional development practices (CI/CD).  