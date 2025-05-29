# Troubleshooting Guide

## 🚨 Common Issues and Solutions

### 1. Spring Boot 3.x Profile Configuration Error

**Error:**
```
Property 'spring.profiles' is invalid and should be replaced with 'spring.config.activate.on-profile'
```

**Cause:** Spring Boot 3.x deprecated the `spring.profiles` property in favor of `spring.config.activate.on-profile`.

**Solution:**
- Update GitHub Actions workflow to use `SPRING_PROFILES_ACTIVE` instead of `SPRING_PROFILES`
- Update configuration files to use the new property format
- Add proper profile activation in `application-test.yml`:

```yaml
spring:
  config:
    activate:
      on-profile: test
```

### 2. ApplicationContext Loading Issues

**Error:**
```
Failed to load ApplicationContext for [WebMergedContextConfiguration...]
```

**Cause:** Usually related to profile configuration or missing dependencies.

**Solutions:**
1. Ensure proper test profile configuration
2. Check that all required dependencies are in `build.gradle`
3. Verify test configuration files are properly structured

### 3. Coverage Threshold Violations

**Error:**
```
Rule violated for class OrderServiceApplication: lines covered ratio is 0.33, but expected minimum is 0.75
```

**Solution:** Exclude application main class and configuration classes from individual coverage requirements:

```gradle
jacocoTestCoverageVerification {
    afterEvaluate {
        classDirectories.setFrom(files(classDirectories.files.collect {
            fileTree(dir: it, exclude: [
                '**/OrderServiceApplication.class',
                '**/configuration/**',
                '**/config/**'
            ])
        }))
    }
}
```

### 4. Custom GitHub Actions Not Found

**Error:**
```
uses: cbuelvasc/actions/setup-java-base@master
# Action not found
```

**Solution:** Replace with standard GitHub Actions:
```yaml
- name: Set up JDK ${{ env.JAVA_VERSION }}
  uses: actions/setup-java@v4
  with:
    java-version: ${{ env.JAVA_VERSION }}
    distribution: ${{ env.JAVA_DISTRIBUTION }}
```

### 5. Gradle Wrapper Permission Issues

**Error:**
```
Permission denied: ./gradlew
```

**Solution:** Add execute permissions in GitHub Actions:
```yaml
- name: Grant execute permission for gradlew
  run: chmod +x gradlew
```

## 🔧 Best Practices for Spring Boot 3.x

1. **Profile Configuration:**
   - Use `SPRING_PROFILES_ACTIVE` environment variable
   - Use `spring.config.activate.on-profile` in YAML files

2. **Testing:**
   - Use `@ActiveProfiles("test")` in test classes
   - Configure test-specific properties in `application-test.yml`

3. **Coverage:**
   - Exclude main application class from individual coverage rules
   - Set reasonable coverage thresholds (80% overall, 75% per class)

4. **Dependencies:**
   - Use Spring Boot 3.x compatible dependencies
   - Test with the same Java version used in production

## 🚀 Verification Commands

Run these commands to verify everything works:

```bash
# Run tests
./gradlew clean test

# Check coverage
./gradlew jacocoTestReport jacocoTestCoverageVerification

# Code quality
./gradlew checkstyleMain checkstyleTest

# Full build
./gradlew build
```

## 📋 Configuration Checklist

- [ ] `SPRING_PROFILES_ACTIVE` instead of `SPRING_PROFILES`
- [ ] Proper profile activation in `application-test.yml`
- [ ] Coverage exclusions for application main class
- [ ] Execute permissions for `gradlew` in CI/CD
- [ ] Standard GitHub Actions instead of custom ones
- [ ] Java 21 compatibility in all configurations 