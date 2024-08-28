# Takealot Automated Testing Framework

## Introduction
This project is an automated testing framework for the Takealot e-commerce platform, built using Selenium WebDriver and TestNG. It demonstrates a robust approach to web application testing, incorporating best practices in test automation and continuous integration.

## Features
- Page Object Model (POM) design pattern for improved maintainability
- TestNG for test orchestration and parallel execution
- Extent Reports for comprehensive test reporting
- Log4j for logging
- Data-driven testing using Excel for test data management
- Configurable test environment using properties files
- Cross-browser testing support (Chrome, Firefox, IE)
- Jenkins integration for CI/CD

## Test Coverage
- User authentication (Login/Logout)
- Account management (Personal Details, Business Details)
- Product search and navigation
- Shopping cart operations
- Wishlist functionality
- Newsletter subscription
- Address book management
- Promo code application

## Prerequisites
- Java JDK 8 or higher
- Maven 3.6.3 or higher
- Chrome, Firefox, and IE browsers installed
- Jenkins (for CI/CD integration)

## Setup
1. Clone the repository:
   ```
   git clone https://github.com/your-username/takealot-testing-framework.git
   ```
2. Navigate to the project directory:
   ```
   cd takealot-testing-framework
   ```
3. Install dependencies:
   ```
   mvn clean install
   ```

## Configuration
1. Update `src/test/resources/config.properties` with your test environment details:
   ```
   browser=chrome
   base_url=https://www.takealot.com
   username=your_test_username
   password=your_test_password
   ```
2. Update `src/test/resources/TestData.xlsx` with your test data.

## Running Tests
To run tests using Maven:
```
mvn test
```

To run a specific test group:
```
mvn test -Dgroups=regression
```

## Jenkins Integration
1. Create a new Jenkins job
2. Configure Source Code Management to point to your repository
3. Add build steps:
   ```
   mvn clean test
   ```
4. Configure post-build actions to publish TestNG results and archive artifacts

## Reporting
- Extent Reports are generated in the `test-output` directory
- TestNG reports are available in the `target/surefire-reports` directory

## Project Structure
```
takealot-testing-framework/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── utilities/
│   │           ├── ConfigReader.java
│   │           └── ExcelDataReader.java
│   │
│   └── test/
│       ├── java/
│       │   ├── pages/
│       │   │   ├── HomePage.java
│       │   │   ├── LoginPage.java
│       │   │   └── ...
│       │   │
│       │   └── test_classes/
│       │       ├── BaseTest.java
│       │       ├── LoginTest.java
│       │       └── ...
│       │
│       └── resources/
│           ├── config.properties
│           └── TestData.xlsx
│
├── test-output/
├── target/
├── pom.xml
├── testng.xml
└── README.md
```

## Dependencies
- Selenium WebDriver 4.23.1
- TestNG 7.10.2
- Apache POI 5.3.0
- Log4j 2.23.1
- Extent Reports 5.1.2
- Apache Commons Collections 4.5.0-M2
- Apache Commons IO 2.16.1

For a complete list of dependencies, please refer to the `pom.xml` file.

