# Order Service

A Spring Boot microservice for handling order operations with comprehensive CI/CD pipeline and Docker support.

## 🚀 Features

- **Spring Boot 3.5.0** with Java 21
- **RESTful API** design with validation
- **Docker** containerization with multi-stage builds
- **Spring Boot Actuator** for monitoring
- **Lombok** for reduced boilerplate code
- **JaCoCo** for test coverage (85% threshold)
- **Checkstyle** for code quality
- **Automated CI/CD** with GitHub Actions and Docker image building

## 🛠️ Prerequisites

- Java 21 or later
- Gradle 8.x
- Docker (optional, for containerization)
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

### Docker Deployment

```bash
# Build Docker image
docker build -t order-service:latest .

# Run with Docker
docker run -p 8080:8080 order-service:latest

# Run with Docker Compose (if available)
docker-compose up -d
```

### Accessing the Application

- **Application**: http://localhost:8080
- **Custom Health Check**: http://localhost:8080/api/v1/health
- **Custom Info**: http://localhost:8080/api/v1/info
- **Actuator Health**: http://localhost:8080/actuator/health
- **Actuator Info**: http://localhost:8080/actuator/info

## 📡 API Endpoints

### Health & Information
- `GET /api/v1/health` - Custom application health status
- `GET /api/v1/info` - Application information and version
- `GET /actuator/health` - Spring Boot Actuator health check
- `GET /actuator/info` - Spring Boot Actuator application info

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

## 🐳 Docker Support

### Multi-Stage Build Features
- **Optimized Image Size**: Uses Alpine Linux for minimal footprint
- **Security**: Runs as non-root user
- **Performance**: JVM optimized for containers
- **Health Checks**: Built-in container health monitoring
- **Timezone Support**: Configurable timezone (default: America/Bogota)

### Docker Build Arguments
- `BUILD_DATE`: Build timestamp
- `VCS_REF`: Git commit hash
- `VERSION`: Application version

### Environment Variables
- `JAVA_OPTS`: JVM configuration options
- `TZ`: Timezone configuration
- `SPRING_PROFILES_ACTIVE`: Active Spring profiles

## 📦 CI/CD Pipeline

The project uses GitHub Actions for automated testing, building, and deployment:

### Pipeline Features
- ✅ **Automated Testing**: Runs unit and integration tests
- 📊 **Coverage Reporting**: JaCoCo coverage with 85% threshold
- 🔍 **Code Quality**: Checkstyle validation
- 🐳 **Docker Images**: Builds and pushes to GitHub Container Registry
- 📁 **Artifact Generation**: Builds and uploads JAR files
- 🚀 **Automated Deployment**: Deploys to production on master branch
- 🎯 **Multi-Environment**: Supports master and develop branches

### Pipeline Jobs

1. **Build and Test**
   - Sets up Java 21 environment with Temurin distribution
   - Caches Gradle dependencies for faster builds
   - Runs all tests with coverage verification (85% threshold)
   - Publishes test results and coverage reports

2. **Docker Build**
   - Builds optimized Docker images using multi-stage builds
   - Pushes images to GitHub Container Registry
   - Supports multiple platforms (linux/amd64)
   - Includes proper tagging and metadata

3. **Deploy** (master branch only)
   - Automated deployment to production environment
   - Uses built Docker images for deployment

### Triggering the Pipeline

The pipeline runs automatically on:
- Push to `master` or `develop` branches
- Pull requests to `master` or `develop` branches

## 📋 Requirements

### Test Coverage
- **Minimum Overall Coverage**: 85%
- **Minimum Class Coverage**: 75%

### Code Quality
- Checkstyle configuration in `checkstyle.xml`
- All code must pass Checkstyle validation

## 🔧 Configuration

### Application Properties
- Development: `src/main/resources/application.properties`
- Testing: `src/test/resources/application-test.properties` (if needed)

### Spring Profiles
- `test`: For testing environment
- `prod`: For production environment

### Gradle Configuration
- Main build file: `build.gradle`
- Dependencies and plugins configured for Spring Boot 3.x
- Lombok integration for reduced boilerplate
- Spring Boot Validation for request validation

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
│   │   │       ├── controller/
│   │   │       │   └── HealthController.java
│   │   │       └── OrderServiceApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       ├── java/
│       │   └── com/xeppelin/orderservice/
│       │       ├── controller/
│       │       │   └── HealthControllerTest.java
│       │       └── OrderServiceApplicationTests.java
│       └── resources/
├── build.gradle                # Build configuration
├── checkstyle.xml             # Code style rules
├── Dockerfile                 # Multi-stage Docker build
├── gradle.properties          # Gradle properties
└── README.md                  # This file
```

## 🚀 Deployment

### JAR Deployment
```bash
java -jar build/libs/order-service-0.0.1-SNAPSHOT.jar
```

### Docker Deployment
```bash
# Using pre-built image from registry
docker pull ghcr.io/cbuelvasc/order-service:latest
docker run -p 8080:8080 ghcr.io/cbuelvasc/order-service:latest

# With environment variables
docker run -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=prod \
  -e TZ=America/New_York \
  ghcr.io/cbuelvasc/order-service:latest
```

## 🤝 Contributing

1. Create a feature branch from `develop`
2. Make your changes
3. Ensure all tests pass: `./gradlew test integrationTest`
4. Verify coverage meets requirements: `./gradlew jacocoTestCoverageVerification`
5. Run code quality checks: `./gradlew checkstyleMain checkstyleTest`
6. Build and test Docker image: `docker build -t order-service:test .`
7. Create a pull request

## 📞 Support

For issues and questions, please create an issue in the repository. 