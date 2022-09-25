# Phoenix Automation Framework
## _Test Automation Academy Project_



[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)



- Java 1.8
- Maven
- TestNG
- Cucumber
- Rest Assured
- Selenium

## Features

- Performs UI and API Automated Tests for both Inwarranty Flow and OutWarranty Flow
- Integrated with Jenkins CI for Continious Testing for UI and API Component 
- Categorizing the Tests in both TestNG and Cucumber
- Performs Parallel Testing and Isolated Tests


## Tech

Framework uses a number of dependencies to work properly:

- Selenium WebDriver
- TestNG
- Cucumber
- Cucumber TestNG
- Rest Assured
- OpenCSV
- Apache POI
- MySQL JDBC Connector
- JsonSchemaValidator
- Java-Faker
- Gson

## Adding New Dependencies

New Dependencies can be added in pom.xml at root level under dependencies tag

Example
```
<dependency>
			<groupId>io.rest-assured</groupId>
			<artifactId>rest-assured</artifactId>
			<version>5.1.1</version>
			<scope>test</scope>
		</dependency>
```



## Plugins

Maven Plugins used in the Project

| Plugin | README |
| ------ | ------ |
| Maven SureFire | https://maven.apache.org/surefire/maven-surefire-plugin |
| Exec Maven Plugin | https://www.mojohaus.org/exec-maven-plugin/ |

To Run the Automated Test for TestNG from cli...

```sh
mvn -Dexec.classpathScope=test  -Dexec.arguments="dev,api,sanity" test-compile  exec:java -Dexec.cleanupDaemonThreads=false -X
```


To Run the Automated Test for Cucumber from cli...

```sh
mvn test -X
```

