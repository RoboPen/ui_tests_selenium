## UI Tests Examples

Used tools: **Java**, **Selenium WebDriver**, **TestNG**, **Allure**

## Configuration
By modifying ```config.properties``` file the following starting options can be set:
1. Browser type
2. Incognito mode
3. Headless mode
4. Add screenshot to a report on test failure or block

Test classes run in parallel by default

## Running tests and generating Allure report

Use maven command: ```mvn clean test```  
To run specific group of tests: ```mvn clean test -Dgroups=groupName```

## Accessing the report manually

1. Generate the report by running: ```mvn allure:report```
2. You can access the report by opening ```target/site/allure-maven-plugin/index.html``` in a browser

## Accessing the report automatically

To generate and open the report in your default browser run: ```mvn allure:serve```