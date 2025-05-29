# Order Service

A Spring Boot microservice for handling order operations.

## 🚀 Features

- **Spring Boot 3.5.0** with Java 21
- **RESTful API** design
- **Spring Boot Actuator** for monitoring
- **JaCoCo** for test coverage
- **Checkstyle** for code quality
- **Automated CI/CD** with GitHub Actions

## 🛠️ Prerequisites

- Java 21 or later
- Gradle 8.x
- Git

## 🏃‍♂️ Quick Start

### Local Development

```bash
# Clone the repository
git clone <your-repo-url>
cd order-service

# Run tests
./gradlew test

# Run the application
./gradlew bootRun

# Build the application
./gradlew build
```

### Accessing the Application

- **Application**: http://localhost:8080
- **Health Check**: http://localhost:8080/actuator/health
- **Application Info**: http://localhost:8080/actuator/info

## 🧪 Testing

### Run Unit Tests
```bash
./gradlew test
```

### Run Integration Tests
```bash
./gradlew integrationTest
```

### Generate Coverage Report
```bash
./gradlew jacocoTestReport
```

Coverage reports are generated in `build/reports/jacoco/test/html/index.html`

### Code Quality Check
```bash
./gradlew checkstyleMain checkstyleTest
```

## 📦 CI/CD Pipeline

The project uses GitHub Actions for automated testing and building:

### Pipeline Features
- ✅ **Automated Testing**: Runs unit and integration tests
- 📊 **Coverage Reporting**: JaCoCo coverage with 80% threshold
- 🔍 **Code Quality**: Checkstyle validation
- 📁 **Artifact Generation**: Builds and uploads JAR files
- 🎯 **Multi-Environment**: Supports master, main, and develop branches

### Pipeline Jobs

1. **Build and Test**
   - Sets up Java 21 environment
   - Caches Gradle dependencies
   - Runs all tests with coverage verification
   - Publishes test results and coverage reports

2. **Build Application**
   - Builds the application JAR
   - Uploads build artifacts

### Triggering the Pipeline

The pipeline runs automatically on:
- Push to `master`, `main`, or `develop` branches
- Pull requests to `master`, `main`, or `develop` branches

## 📋 Requirements

### Test Coverage
- **Minimum Overall Coverage**: 80%
- **Minimum Class Coverage**: 75%

### Code Quality
- Checkstyle configuration in `checkstyle.xml`
- All code must pass Checkstyle validation

## 🔧 Configuration

### Application Properties
- Development: `src/main/resources/application.yml`
- Testing: `src/test/resources/application-test.yml`

### Gradle Configuration
- Main build file: `build.gradle`
- Dependencies and plugins configured for Spring Boot 3.x

## 📁 Project Structure

```
order-service/
├── .github/
│   └── workflows/
│       └── deploy.yml          # CI/CD pipeline
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/xeppelin/orderservice/
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   └── com/xeppelin/orderservice/
│       └── resources/
├── build.gradle                # Build configuration
├── checkstyle.xml             # Code style rules
└── README.md                  # This file
```

## 🚀 Deployment

The application can be deployed using the generated JAR file:

```bash
java -jar build/libs/order-service-0.0.1-SNAPSHOT.jar
```

## 🤝 Contributing

1. Create a feature branch from `develop`
2. Make your changes
3. Ensure all tests pass: `./gradlew test integrationTest`
4. Verify coverage meets requirements: `./gradlew jacocoTestCoverageVerification`
5. Run code quality checks: `./gradlew checkstyleMain checkstyleTest`
6. Create a pull request

## 📞 Support

For issues and questions, please create an issue in the repository. 