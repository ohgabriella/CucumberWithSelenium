# Selenium webdriver with Cucumber


## requirements

1. jdk/jre
1. maven version

## setup

1. create a maven project
1. add the maven dependencies: selenium-java, selenium-chrome-driver, junit, cucumber-java, cucumber-junit, rest-assured
1. create the "features" package in resource
1. create the packages for runners and steps
1. add the configuration for run the runner correctly. It will be like this

    ```
   @RunWith(Cucumber.class)
      @CucumberOptions(
              tags = "@AllCenarios",
              features = "src/test/resources/features/search.feature",
              glue = {"steps.search"},
              plugin = {"pretty",
                      "html:target/cucumber-pretty.html",
                      "json:target/cucumber.json",
                      "junit:target/JunitCucumber.json"},
              snippets = CAMELCASE,
              monochrome = true
      )   
   ```
 1. put the chromedriver.exe (you can find in the Selenium website) in your project - in this project I put inside the resource package
   
## create the first Scenario


