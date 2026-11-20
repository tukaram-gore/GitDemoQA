# GitDemoQA - Selenium Automation Framework (POM)

A Java-based test automation framework built using **Selenium WebDriver**, **TestNG**, and the **Page Object Model (POM)** design pattern.

## Tech Stack
* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Testing Framework:** TestNG
* **Build Tool:** Maven
* **Design Pattern:** Page Object Model (POM)

## Project Structure
```text
SeleniumFrameworkPOM/
├── src/
│   ├── main/java/        # Page classes and base utilities
│   └── test/java/        # TestNG test scripts
├── testng.xml            # Main TestNG suite configuration
├── testng2.xml           # Secondary TestNG suite configuration
└── pom.xml               # Maven dependencies and plugins
```

## Prerequisites
* Java JDK 11 or higher
* Apache Maven
* Chrome / Edge browser installed

## How to Run Tests
1. Clone the repository:
   ```bash
   git clone https://github.com/tukaram-gore/GitDemoQA.git
   ```
2. Navigate to the project folder:
   ```bash
   cd GitDemoQA/SeleniumFrameworkPOM
   ```
3. Run the tests using Maven:
   ```bash
   mvn clean test
   ```
